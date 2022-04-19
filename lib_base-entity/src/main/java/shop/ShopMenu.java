package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * ShopMenu
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class ShopMenu   {
  @JsonProperty("shopId")
  private String shopId ;

  @JsonProperty("itemId")
  private Integer itemId ;

  @JsonProperty("itemPrice")
  private BigDecimal itemPrice ;

  @JsonProperty("note")
  private String note ;

  @JsonProperty("image")
  private String image ;
}

