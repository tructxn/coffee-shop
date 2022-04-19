package shop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * CoffeeShop
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class CoffeeShop   {
  @JsonProperty("shopId")
  private String shopId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("latitude")
  private Long latitude = null;

  @JsonProperty("longitude")
  private Long longitude = null;

  @JsonProperty("queueSize")
  private Integer queueSize = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    INIT("init"),
    
    ACTIVE("active"),
    
    CLOSE("close");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public CoffeeShop shopId(String shopId) {
    this.shopId = shopId;
    return this;
  }

  /**
   * Get shopId
   * @return shopId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getShopId() {
    return shopId;
  }

  public void setShopId(String shopId) {
    this.shopId = shopId;
  }

  public CoffeeShop name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CoffeeShop address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CoffeeShop latitude(Long latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getLatitude() {
    return latitude;
  }

  public void setLatitude(Long latitude) {
    this.latitude = latitude;
  }

  public CoffeeShop longitude(Long longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getLongitude() {
    return longitude;
  }

  public void setLongitude(Long longitude) {
    this.longitude = longitude;
  }

  public CoffeeShop queueSize(Integer queueSize) {
    this.queueSize = queueSize;
    return this;
  }

  /**
   * Get queueSize
   * @return queueSize
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getQueueSize() {
    return queueSize;
  }

  public void setQueueSize(Integer queueSize) {
    this.queueSize = queueSize;
  }

  public CoffeeShop status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoffeeShop coffeeShop = (CoffeeShop) o;
    return Objects.equals(this.shopId, coffeeShop.shopId) &&
        Objects.equals(this.name, coffeeShop.name) &&
        Objects.equals(this.address, coffeeShop.address) &&
        Objects.equals(this.latitude, coffeeShop.latitude) &&
        Objects.equals(this.longitude, coffeeShop.longitude) &&
        Objects.equals(this.queueSize, coffeeShop.queueSize) &&
        Objects.equals(this.status, coffeeShop.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shopId, name, address, latitude, longitude, queueSize, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoffeeShop {\n");

    sb.append("    shopId: ").append(toIndentedString(shopId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    queueSize: ").append(toIndentedString(queueSize)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

