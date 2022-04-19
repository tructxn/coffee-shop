package dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import dto.response.ResponseStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ShopResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class ShopResponse   {
  @JsonProperty("data")
  private CoffeeShop data = null;

  @JsonProperty("responseStatus")
  private ResponseStatus responseStatus = null;

  public ShopResponse data(CoffeeShop data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CoffeeShop getData() {
    return data;
  }

  public void setData(CoffeeShop data) {
    this.data = data;
  }

  public ShopResponse responseStatus(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  /**
   * Get responseStatus
   * @return responseStatus
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ResponseStatus getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(ResponseStatus responseStatus) {
    this.responseStatus = responseStatus;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShopResponse shopResponse = (ShopResponse) o;
    return Objects.equals(this.data, shopResponse.data) &&
        Objects.equals(this.responseStatus, shopResponse.responseStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, responseStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShopResponse {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

