package shop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ShopQueue
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class ShopQueue   {
  @JsonProperty("shopId")
  private String shopId = null;

  @JsonProperty("queueId")
  private Integer queueId = null;

  @JsonProperty("queueName")
  private String queueName = null;

  @JsonProperty("queueSize")
  private Integer queueSize = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

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

  @JsonProperty("updatedDate")
  private String updatedDate = null;

  @JsonProperty("updatedBy")
  private String updatedBy = null;

  public ShopQueue shopId(String shopId) {
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

  public ShopQueue queueId(Integer queueId) {
    this.queueId = queueId;
    return this;
  }

  /**
   * Get queueId
   * @return queueId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getQueueId() {
    return queueId;
  }

  public void setQueueId(Integer queueId) {
    this.queueId = queueId;
  }

  public ShopQueue queueName(String queueName) {
    this.queueName = queueName;
    return this;
  }

  /**
   * Get queueName
   * @return queueName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getQueueName() {
    return queueName;
  }

  public void setQueueName(String queueName) {
    this.queueName = queueName;
  }

  public ShopQueue queueSize(Integer queueSize) {
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

  public ShopQueue status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ShopQueue updatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
  **/
  @ApiModelProperty(value = "")


  public String getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }

  public ShopQueue updatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
  **/
  @ApiModelProperty(value = "")


  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShopQueue shopQueue = (ShopQueue) o;
    return Objects.equals(this.shopId, shopQueue.shopId) &&
        Objects.equals(this.queueId, shopQueue.queueId) &&
        Objects.equals(this.queueName, shopQueue.queueName) &&
        Objects.equals(this.queueSize, shopQueue.queueSize) &&
        Objects.equals(this.status, shopQueue.status) &&
        Objects.equals(this.updatedDate, shopQueue.updatedDate) &&
        Objects.equals(this.updatedBy, shopQueue.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shopId, queueId, queueName, queueSize, status, updatedDate, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShopQueue {\n");

    sb.append("    shopId: ").append(toIndentedString(shopId)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
    sb.append("    queueName: ").append(toIndentedString(queueName)).append("\n");
    sb.append("    queueSize: ").append(toIndentedString(queueSize)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
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

