package backend.order.api;

import backend.order.serivce.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.api.ResponseStatus;
import io.swagger.annotations.ApiParam;
import order.Order;
import order.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import shop.ListOrderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")

@Controller
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final OrderService orderService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.orderService = orderService;
    }

    public ResponseEntity<OrderResponse> cancelOrder(@ApiParam(value = "cancel order Id . ", required = true) @PathVariable("orderId") String orderId, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<OrderResponse>(orderService.cancelOrder("test"), HttpStatus.OK);
        }
        return new ResponseEntity<OrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OrderResponse> getOrderId(@ApiParam(value = "get detail information of order . ", required = true) @PathVariable("orderId") String orderId, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<OrderResponse>(orderService.getOrder(orderId), HttpStatus.OK);
        }

        return new ResponseEntity<OrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<OrderResponse> orderCoffee(@ApiParam(value = "create order", required = true) @Valid @RequestBody Order body, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer, BindingResult bindingResult) {
        String accept = request.getHeader("Accept");
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<OrderResponse>(HttpStatus.BAD_REQUEST);
        }
        if (accept != null && accept.contains("application/json")) {
            if (accept != null && accept.contains("application/json")) {
                return new ResponseEntity<OrderResponse>(orderService.saveOrder(body), HttpStatus.OK);
            }
        }

        return new ResponseEntity<OrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ListOrderResponse> getListOrderInQueue(@ApiParam(value = "clientId") @PathVariable("queueId") Integer queueId, @PathVariable("shopId") String shopId, @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<ListOrderResponse>(orderService.getWaitingOrder(queueId, shopId), HttpStatus.OK);
        }

        return new ResponseEntity<ListOrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<ResponseStatus> processOrder(@ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "") @Valid @RequestBody Order body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<ResponseStatus>(orderService.processOrder(body), HttpStatus.OK);
        }

        return new ResponseEntity<ResponseStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ListOrderResponse> getListProcessingOrder(Integer queueId, String shopId, String clientId, String bearer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<ListOrderResponse>(orderService.getProcessingOrder(queueId, shopId), HttpStatus.OK);
        }

        return new ResponseEntity<ListOrderResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
}
