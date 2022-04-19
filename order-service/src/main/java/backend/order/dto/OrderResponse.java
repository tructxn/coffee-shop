package backend.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import dto.response.ResponseStatus;
import org.springframework.validation.annotation.Validated;

/**
 * OrderResponse
 */
@Validated
@Builder
public class OrderResponse   {
  @JsonProperty("data")
  private Order data;

  @JsonProperty("responseStatus")
  private ResponseStatus responseStatus;
}

