package backend.order.repository;

import common.exeption.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRedisRepositoryImpl implements OrderRedisRepository {
    private Logger logger = LoggerFactory.getLogger(OrderRedisRepositoryImpl.class);
    @Autowired
    private Jedis jedis;


    public Boolean saveOrderToWaiting(Integer queueId, String shopId, String orderId) {
        try {
            String key = buildWaitingOrderkey(queueId, shopId);
            logger.info("save {} to waiting list . list : {}", orderId, key);
            return jedis.zadd(buildWaitingOrderkey(queueId, shopId), getPriority(orderId), orderId) > 0;
        } catch (Exception e) {
            logger.error("save redis error ", e);
            throw new DatabaseException();
        }
    }

    @Override
    public Boolean saveToProcessing(Integer queueId, String shopId, String orderId) {
        try {
            String key = buildProcessOrderKey(queueId, shopId);
            logger.info("save {} to process list . list : {}", orderId, key);
            return jedis.hset(buildProcessOrderKey(queueId, shopId), orderId, String.valueOf(System.currentTimeMillis())) > 0;
        } catch (Exception e) {
            logger.error("save redis error ", e);
            throw new DatabaseException();
        }
    }

    @Override
    public Boolean removeFromWaiting(Integer queueId, String shopId, String orderId) {
        String key = buildWaitingOrderkey(queueId, shopId);
        logger.info("remove {} to waiting list . list : {}", orderId, key);
        return jedis.zrem(buildWaitingOrderkey(queueId, shopId), orderId) > 0;
    }

    @Override
    public Boolean removeFromProcessing(Integer queueId, String shopId, String orderId) {
        String key = buildWaitingOrderkey(queueId, shopId);
        logger.info("remove {} to process list . list : {}", orderId, key);
        return jedis.hdel(buildProcessOrderKey(queueId, shopId), orderId) > 0;
    }


    //second from the midnight
    private double getPriority(String orderId) {
        ZonedDateTime nowZoned = ZonedDateTime.now();
        Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
        Duration duration = Duration.between(midnight, Instant.now());
        long seconds = duration.getSeconds();
        return seconds;
    }

    @Override
    public List<String> getProcessingOrder(String shopId, Integer queueId) {
        return new ArrayList<>(jedis.zrange(buildWaitingOrderkey(queueId, shopId), 0, -1));
    }

    @Override
    public Long getOrderIndex(String shopId, Integer queueId, String orderId) {
        return jedis.zrank(buildWaitingOrderkey(queueId, shopId), orderId);
    }

    private String buildWaitingOrderkey(Integer queueId, String shopId) {
        return "LIST_ORDER_WAITING" + "_" + shopId + "_" + queueId;
    }

    private String buildProcessOrderKey(Integer queueId, String shopId) {
        return "LIST_ORDER_PROCESS" + "_" + shopId + "_" + queueId;
    }
}
