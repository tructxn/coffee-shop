package backend.order.utils;


import backend.order.dto.Order;
import backend.order.entity.OrderEntity;
import backend.order.entity.OrderItemEntity;
import dto.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component("orderMapperUtils")
public class OrderMapperUtils {

    @Autowired
    public OrderMapperUtils() {
    }

    public OrderEntity buildNewOrderEntity(Order order) {
        OrderEntity.OrderEntityBuilder orderEntityBuilder = order.toEntity()
                .orderId(OrderUtils.buildOrderId())
                .createdAt(System.currentTimeMillis());
        orderEntityBuilder.orders(order.getOrders().stream().map(item -> {
            OrderItemEntity.OrderItemEntityBuilder builder = item.toEntity(orderEntityBuilder.build());
            builder.createdAt(System.currentTimeMillis());
            builder.orderItemId(OrderUtils.buildOrderItemId());
            return builder.build();
        }).collect(Collectors.toList()));
        orderEntityBuilder.status(OrderStatus.PENDING.name());
        return orderEntityBuilder.build();
    }
}
