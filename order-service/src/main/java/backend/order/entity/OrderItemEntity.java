package backend.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import order.OrderItem;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * OrderItem
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "ORDER_ITEMS")
public class OrderItemEntity {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    private String orderItemId;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity orderId;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "ORIGINAL_PRICE")
    private BigDecimal originalPrice;
    @Column(name = "DISCOUNT")
    private String discount;
    @Column(name = "DISCOUNT_AMOUNT")
    private BigDecimal discountAmount;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "CREATED_AT")
    protected Long createdAt;
    @Column(name = "CREATED_BY")
    protected String createdBy;
    @Column(name = "UPDATED_AT")
    protected Long updatedAt;
    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    public OrderItem toDto() {
        OrderItem.OrderItemBuilder builder = OrderItem.builder();
        builder.orderItemId(orderItemId);
        builder.orderId(orderId.getOrderId());
        builder.itemId(itemId);
        builder.quantity(quantity);
        builder.price(price);
        builder.originalPrice(originalPrice);
        builder.discount(discount);
        builder.discountAmount(discountAmount);
        builder.note(note);
        return builder.build();
    }
}

