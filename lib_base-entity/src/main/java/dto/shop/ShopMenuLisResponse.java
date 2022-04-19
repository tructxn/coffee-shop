package dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.response.ResponseStatus;
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

