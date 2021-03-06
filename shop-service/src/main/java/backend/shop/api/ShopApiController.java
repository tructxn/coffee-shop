package backend.shop.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.api.ResponseStatus;
import io.swagger.annotations.ApiParam;
import shop.ListOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")

@Controller
public class ShopApiController implements ShopApi {

    private static final Logger log = LoggerFactory.getLogger(ShopApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ShopApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ListOrderResponse> getListOrderInQueue(@ApiParam(value = "clientId" ) @RequestHeader(value="clientId", required=false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role" ) @RequestHeader(value="bearer", required=false) String bearer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ListOrderResponse>(objectMapper.readValue("{\"empty\": false}", ListOrderResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ListOrderResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ListOrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseStatus> processOrder(@ApiParam(value = "clientId" ) @RequestHeader(value="clientId", required=false) String clientId, @ApiParam(value = ""  )  @Valid @RequestBody Object body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseStatus>(objectMapper.readValue("{\"empty\": false}", ResponseStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseStatus>(HttpStatus.NOT_IMPLEMENTED);
    }
}
