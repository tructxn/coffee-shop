package backend.order.serivce;

import backend.order.dto.OrderResponse;
import order.Order;
import org.springframework.stereotype.Service;
import shop.OrderWaitingResponse;

@Service
public interface OrderService {
    OrderResponse getOrder(String orderId);
    OrderResponse cancelOrder(String orderId);
    OrderResponse saveOrder(Order body);
    OrderWaitingResponse getWaitingOrder(Integer queueId, String shopId);
}
