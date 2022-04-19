package dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import dto.response.ResponseStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * LoginResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")


public class LoginResponse   {
  @JsonProperty("responseStatus")
  private ResponseStatus responseStatus = null;

  @JsonProperty("refreshToken")
  private String refreshToken = null;

  @JsonProperty("jwtAccessToken")
  private String jwtAccessToken = null;

  public LoginResponse responseStatus(ResponseStatus responseStatus) {
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

  public LoginResponse refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Get refreshToken
   * @return refreshToken
  **/
  @ApiModelProperty(value = "")


  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public LoginResponse jwtAccessToken(String jwtAccessToken) {
    this.jwtAccessToken = jwtAccessToken;
    return this;
  }

  /**
   * Get jwtAccessToken
   * @return jwtAccessToken
  **/
  @ApiModelProperty(value = "")


  public String getJwtAccessToken() {
    return jwtAccessToken;
  }

  public void setJwtAccessToken(String jwtAccessToken) {
    this.jwtAccessToken = jwtAccessToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponse loginResponse = (LoginResponse) o;
    return Objects.equals(this.responseStatus, loginResponse.responseStatus) &&
        Objects.equals(this.refreshToken, loginResponse.refreshToken) &&
        Objects.equals(this.jwtAccessToken, loginResponse.jwtAccessToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, refreshToken, jwtAccessToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");

    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    jwtAccessToken: ").append(toIndentedString(jwtAccessToken)).append("\n");
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

