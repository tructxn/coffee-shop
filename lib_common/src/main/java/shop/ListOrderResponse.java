package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.api.ResponseStatus;
import lombok.Builder;
import order.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * OrderProcessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")

@Builder
public class ListOrderResponse {
  @JsonProperty("data")
  @Valid
  @NotNull
  private List<Order> data;

  @JsonProperty("ResponseStatus")
  private ResponseStatus responseStatus;
}

