package order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * Order
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("userId")
    @NotNull @Size(min = 4, max = 50, message = "max size 50")
    private String userId;

    @JsonProperty("shopId")
    @NotNull @Size(max = 50, message = "max size 50")
    private String shopId;

    @JsonProperty("orders")
    @NotNull
    private List<OrderItem> orders;

    @JsonProperty("originalPrice")
    @NotNull
    private BigDecimal originalPrice;

    @JsonProperty("discount")
    @NotNull @Size(max = 50, message = "max size 50")
    private String discount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("discountAmount")
    @NotNull
    private BigDecimal discountAmount;

    @JsonProperty("totalPrice")
    @NotNull
    private BigDecimal totalPrice;

    @JsonProperty("queueId")
    @NotNull
    private Integer queueId;

    @JsonProperty("estimateFinishTime")
    private BigDecimal estimateFinishTime;

    @JsonProperty("queueIndex")
    private Integer queueIndex;
}

