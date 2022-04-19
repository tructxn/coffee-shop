package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.api.ResponseStatus;
import org.springframework.validation.annotation.Validated;

/**
 * ShopMenuResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class ShopMenuResponse   {
  @JsonProperty("data")
  private ShopMenu data ;

  @JsonProperty("responseStatus")
  private ResponseStatus responseStatus ;
}

