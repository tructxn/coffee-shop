package backend.order.serivce;

import order.OrderResponse;
import common.api.ResponseStatus;
import order.Order;
import org.springframework.stereotype.Service;
import shop.ListOrderResponse;

@Service
public interface OrderService {
    OrderResponse getOrder(String orderId);
    OrderResponse cancelOrder(String orderId);
    OrderResponse saveOrder(Order body);
    ListOrderResponse getWaitingOrder(Integer queueId, String shopId);

    ResponseStatus processOrder(Order body);

    ListOrderResponse getProcessingOrder(Integer queueId, String shopId);
}
