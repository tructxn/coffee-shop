package backend.order.repository;

import order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRedisRepository {
    Boolean saveOrderToWaiting(Order order);

    List<String> getProcessingOrder(String shopId, Integer queueId);

    Long getOrderIndex(Order order);

    Boolean saveToProcessing(Order order);

    Boolean removeFromWaiting(Order order);

    Boolean removeFromProcessing(Order order);

    List<String> getWaitingOrder(String shopId, Integer queueId);
}
