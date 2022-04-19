package common.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

/**
 * ResponseStatus
 */
@Validated
@Builder
public class ResponseStatus   {
  @JsonProperty("resultType")
  private Integer resultType ;

  @JsonProperty("resultCode")
  private Integer resultCode ;

  @JsonProperty("resultMessage")
  private String resultMessage ;
}

