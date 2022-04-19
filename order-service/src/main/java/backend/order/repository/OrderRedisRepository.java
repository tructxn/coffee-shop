package backend.order.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRedisRepository {
    Boolean saveOrderToWaiting(Integer queueId, String shopId, String orderId);

    List<String> getProcessingOrder(String shopId, Integer queueId);

    Long getOrderIndex(String shopId, Integer queueId, String orderId);

    Boolean saveToProcessing(Integer queueId, String shopId, String orderId);

    Boolean removeFromWaiting(Integer queueId, String shopId, String orderId);

    Boolean removeFromProcessing(Integer queueId, String shopId, String orderId);

}
