package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.api.ResponseStatus;
import org.springframework.validation.annotation.Validated;

/**
 * ShopMenuLisResponse
 */
@Validated
public class ShopMenuLisResponse   {
  @JsonProperty("data")
  private ShopMenu data ;

  @JsonProperty("responseStatus")
  private ResponseStatus responseStatus ;
}

