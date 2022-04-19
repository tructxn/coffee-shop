package backend.order.dto;

import backend.order.entity.OrderEntity;
import backend.order.entity.OrderItemEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * OrderItem
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderItem {
  @JsonProperty("orderItemId")
  @NotNull
  @Size(max = 50, message = "max size 50")
  private String orderItemId;

  @JsonProperty("orderId")
  @NotNull @Size(max = 50, message = "max size 50")
  private String orderId;

  @JsonProperty("itemId")
  @NotNull
  private Long itemId;

  @JsonProperty("quantity")
  @NotNull
  private BigDecimal quantity;

  @JsonProperty("price")
  @NotNull
  private BigDecimal price;

  @JsonProperty("originalPrice")
  @NotNull
  private BigDecimal originalPrice;

  @JsonProperty("discount")
  private String discount;

  @JsonProperty("discountAmount")
  private BigDecimal discountAmount;

  @JsonProperty("note")
  private String note;


  public OrderItemEntity.OrderItemEntityBuilder  toEntity(OrderEntity orderEntity) {
    OrderItemEntity.OrderItemEntityBuilder builder = OrderItemEntity.builder();
    builder.orderId(orderEntity);
    builder.itemId(itemId);
    builder.quantity(quantity);
    builder.price(price);
    builder.originalPrice(originalPrice);
    builder.discount(discount);
    builder.discountAmount(discountAmount);
    builder.note(note);
    return builder;
  }
}

