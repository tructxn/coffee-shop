package order;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.api.ResponseStatus;
import lombok.Builder;
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

