package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import common.api.ResponseStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OrderProcessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class OrderProcessResponse   {
  @JsonProperty("data")
  @Valid
  private List<Object> data = null;

  @JsonProperty("ResponseStatus")
  private ResponseStatus responseStatus = null;

  public OrderProcessResponse data(List<Object> data) {
    this.data = data;
    return this;
  }

  public OrderProcessResponse addDataItem(Object dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Object>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")


  public List<Object> getData() {
    return data;
  }

  public void setData(List<Object> data) {
    this.data = data;
  }

  public OrderProcessResponse responseStatus(ResponseStatus responseStatus) {
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
    OrderProcessResponse orderProcessResponse = (OrderProcessResponse) o;
    return Objects.equals(this.data, orderProcessResponse.data) &&
        Objects.equals(this.responseStatus, orderProcessResponse.responseStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, responseStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderProcessResponse {\n");

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

