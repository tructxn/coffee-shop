package backend.order.serivce;

import backend.order.dto.Order;
import backend.order.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse getOrder(String orderId);
    OrderResponse cancelOrder(String orderId);
    OrderResponse saveOrder(Order body);
}
