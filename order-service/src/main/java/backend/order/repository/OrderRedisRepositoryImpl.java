package backend.order.repository;

import common.exeption.DatabaseException;
import order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRedisRepositoryImpl implements OrderRedisRepository {
    private Logger logger = LoggerFactory.getLogger(OrderRedisRepositoryImpl.class);
    @Autowired
    private Jedis jedis;


    public Boolean saveOrderToWaiting(Order order) {
        try {
            String key = buildWaitingOrderkey(order.getQueueId(), order.getShopId());
            logger.info("save {} to waiting list . list : {}", order.getOrderId(), key);
            return jedis.zadd(key, getPriority(order), order.getOrderId()) > 0;
        } catch (Exception e) {
            logger.error("save redis error ", e);
            throw new DatabaseException();
        }
    }

    @Override
    public Boolean saveToProcessing(Order order) {
        try {
            String key = buildProcessOrderKey(order.getQueueId(), order.getShopId());
            logger.info("save {} to process list . list : {}", order.getOrderId(), key);
            return jedis.hset(key, order.getOrderId(), String.valueOf(System.currentTimeMillis())) > 0;
        } catch (Exception e) {
            logger.error("save redis error ", e);
            throw new DatabaseException();
        }
    }

    @Override
    public Boolean removeFromWaiting(@Valid Order order) {
        String key = buildWaitingOrderkey(order.getQueueId(), order.getShopId());
        logger.info("remove {} to waiting list . list : {}", order.getOrderId(), key);
        return jedis.zrem(key, order.getOrderId()) > 0;
    }

    @Override
    public Boolean removeFromProcessing(@Valid Order order) {
        String key = buildWaitingOrderkey(order.getQueueId(), order.getShopId());
        logger.info("remove {} to process list . list : {}", order.getOrderId(), key);
        return jedis.hdel(key, order.getOrderId()) > 0;
    }

    @Override
    public List<String> getProcessingOrder(String shopId, Integer queueId) {
        String key = buildProcessOrderKey(queueId, shopId);
        Map<String, String> processingMap = jedis.hgetAll(key);
        if (processingMap == null || processingMap.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return new ArrayList<>(processingMap.keySet());
    }


    //second from the midnight
    private double getPriority(Order order) {
        return System.currentTimeMillis()/1000;
//        ZonedDateTime nowZoned = ZonedDateTime.now();
//        Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
//        Duration duration = Duration.between(midnight, Instant.now());
//        long seconds = duration.getSeconds();
//        return seconds;
    }

    @Override
    public List<String> getWaitingOrder(String shopId, Integer queueId) {
        return new ArrayList<>(jedis.zrange(buildWaitingOrderkey(queueId, shopId), 0, -1));
    }

    @Override
    public Long getOrderIndex(@Valid Order order) {
        return jedis.zrank(buildWaitingOrderkey(order.getQueueId(), order.getShopId()), order.getOrderId());
    }

    private String buildWaitingOrderkey(Integer queueId, String shopId) {
        return "LIST_ORDER_WAITING" + "_" + shopId + "_" + queueId;
    }

    private String buildProcessOrderKey(Integer queueId, String shopId) {
        return "LIST_ORDER_PROCESS" + "_" + shopId + "_" + queueId;
    }
}
