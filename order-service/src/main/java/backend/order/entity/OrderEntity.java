package backend.order.entity;

import backend.order.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Order
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"order\"")
@Getter
public class OrderEntity {
    @Id
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "USER_ID")
    private String userId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderId", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderItemEntity> orders;
    @Column(name = "SHOP_ID")
    private String shopId;
    @Column(name = "ORIGINAL_PRICE")
    private BigDecimal originalPrice;
    @Column(name = "DISCOUNT")
    private String discount;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DISCOUNT_AMOUNT")
    private BigDecimal discountAmount;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @Column(name = "QUEUE_ID")
    private Integer queueId;
    @Column(name = "ESTIMATE_FINISH_TIME")
    private BigDecimal estimateFinishTime;
    @Column(name = "CREATED_AT")
    protected Long createdAt;
    @Column(name = "CREATED_BY")
    protected String createdBy;
    @Column(name = "UPDATED_AT")
    protected Long updatedAt;
    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    public Order.OrderBuilder toDto() {
        Order.OrderBuilder builder = Order.builder();
        builder.orderId(orderId);
        builder.userId(userId);
        builder.shopId(shopId);
        builder.originalPrice(originalPrice);
        builder.discount(discount);
        builder.status(status);
        builder.discountAmount(discountAmount);
        builder.totalPrice(totalPrice);
        builder.queueId(queueId);
        builder.estimateFinishTime(estimateFinishTime);
        if (orders == null || orders.isEmpty()) {
            builder.orders(Collections.emptyList());
        } else {
            builder.orders(orders.stream().map(v -> v.toDto()).collect(Collectors.toList()));
        }
        return builder;
    }
}

