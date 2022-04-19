package backend.order.utils;


import backend.order.dto.OrderStatus;
import backend.order.entity.OrderEntity;
import backend.order.entity.OrderItemEntity;
import order.Order;
import order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component("orderMapperUtils")
public class OrderMapperUtils {

    @Autowired
    public OrderMapperUtils() {
    }

    public OrderEntity buildNewOrderEntity(Order order) {
        OrderEntity.OrderEntityBuilder orderEntityBuilder = orderDtoToEntity(order)
                .orderId(OrderUtils.buildOrderId())
                .createdAt(System.currentTimeMillis());
        orderEntityBuilder.orders(order.getOrders().stream().map(item -> {
            OrderItemEntity.OrderItemEntityBuilder builder = itemToEntity(item, orderEntityBuilder.build());
            builder.createdAt(System.currentTimeMillis());
            builder.orderItemId(OrderUtils.buildOrderItemId());
            return builder.build();
        }).collect(Collectors.toList()));
        orderEntityBuilder.status(OrderStatus.PENDING.name());
        return orderEntityBuilder.build();
    }

    public OrderEntity.OrderEntityBuilder orderDtoToEntity(Order order) {
            OrderEntity.OrderEntityBuilder builder = OrderEntity.builder();
            builder.orderId(order.getOrderId())
                    .userId(order.getUserId())
                    .shopId(order.getShopId())
                    .originalPrice(order.getOriginalPrice())
                    .discount(order.getDiscount())
                    .queueId(order.getQueueId())
                    .discountAmount(order.getDiscountAmount())
                    .totalPrice(order.getTotalPrice())
                    .estimateFinishTime(order.getEstimateFinishTime());
            return builder;
    }

    public OrderItemEntity.OrderItemEntityBuilder  itemToEntity(OrderItem orderItem, OrderEntity orderEntity) {
        OrderItemEntity.OrderItemEntityBuilder builder = OrderItemEntity.builder();
        builder.orderId(orderEntity);
        builder.itemId(orderItem.getItemId());
        builder.quantity(orderItem.getQuantity());
        builder.price(orderItem.getPrice());
        builder.originalPrice(orderItem.getOriginalPrice());
        builder.discount(orderItem.getDiscount());
        builder.discountAmount(orderItem.getDiscountAmount());
        builder.note(orderItem.getNote());
        return builder;
    }
}
