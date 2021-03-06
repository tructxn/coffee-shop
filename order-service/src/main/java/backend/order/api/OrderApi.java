/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package backend.order.api;

import common.api.ResponseStatus;
import io.swagger.annotations.*;
import order.Order;
import order.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shop.ListOrderResponse;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-04-16T03:40:20.409Z")

@Validated
@Api(value = "order", description = "the order API")
@RequestMapping(value = "/v1")
public interface OrderApi {

    @ApiOperation(value = "cancel order id ", nickname = "cancelOrder", notes = "", response = OrderResponse.class, authorizations = {
        @Authorization(value = "shop_auth", scopes = {
            @AuthorizationScope(scope = "write", description = "Grants read access modify shop entity in your account")
            }),
        @Authorization(value = "user_auth", scopes = {
            @AuthorizationScope(scope = "write", description = "modify user infomation")
            })
    }, tags={ "order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrderResponse.class) })
    @RequestMapping(value = "/order/{orderId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<OrderResponse> cancelOrder(@ApiParam(value = "cancel order Id . ", required = true) @PathVariable("orderId") String orderId, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer);


    @ApiOperation(value = "get order by order ID ", nickname = "getOrderId", notes = "", response = OrderResponse.class, authorizations = {
        @Authorization(value = "user_auth", scopes = {
            @AuthorizationScope(scope = "read", description = "read user entity")
            })
    }, tags={ "order","shop", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = OrderResponse.class) })
    @RequestMapping(value = "/order/{orderId}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<OrderResponse> getOrderId(@ApiParam(value = "get detail information of order . ", required = true) @PathVariable("orderId") String orderId, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer);


    @ApiOperation(value = "order coffee", nickname = "orderCoffee", notes = "", response = OrderResponse.class, authorizations = {
        @Authorization(value = "user_auth", scopes = {
            @AuthorizationScope(scope = "write", description = "modify user infomation")
            })
    }, tags={ "order", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = OrderResponse.class) })
    @RequestMapping(value = "/order",
        produces = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<OrderResponse> orderCoffee(@ApiParam(value = "create order", required = true) @Valid @RequestBody Order body, @ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer, BindingResult bindingResult);


    @ApiOperation(value = "Get list order in queue", nickname = "getListOrderInQueue", notes = "", response = ListOrderResponse.class, authorizations = {
            @Authorization(value = "shop_auth", scopes = {
                    @AuthorizationScope(scope = "read", description = "read shop entity")
            })
    }, tags={"backend/shop", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ListOrderResponse.class) })
    @RequestMapping(value = "/shop/order",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<ListOrderResponse> getListOrderInQueue(@ApiParam(value = "clientId") @RequestParam ("queueId") Integer queueId, @RequestParam("shopId") String shopId, @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer);


    @ApiOperation(value = "Process Order ", nickname = "processOrder", notes = "", response = common.api.ResponseStatus.class, authorizations = {
            @Authorization(value = "shop_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "Grants read access modify shop entity in your account")
            })
    }, tags={"backend/shop", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = common.api.ResponseStatus.class) })
    @RequestMapping(value = "/shop/order",
            produces = { "application/json" },
            method = RequestMethod.PATCH)
    ResponseEntity<ResponseStatus> processOrder(@ApiParam(value = "clientId") @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "") @Valid @RequestBody Order body);

    @ApiOperation(value = "Get list order in queue", nickname = "getListOrderInQueue", notes = "", response = ListOrderResponse.class, authorizations = {
            @Authorization(value = "shop_auth", scopes = {
                    @AuthorizationScope(scope = "read", description = "read shop entity")
            })
    }, tags={"backend/shop", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ListOrderResponse.class) })
    @RequestMapping(value = "/shop/order/processing",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<ListOrderResponse> getListProcessingOrder(@ApiParam(value = "clientId") @RequestParam ("queueId") Integer queueId, @RequestParam("shopId") String shopId, @RequestHeader(value = "clientId", required = false) String clientId, @ApiParam(value = "jwt token contain user infomation and user role") @RequestHeader(value = "bearer", required = false) String bearer);


}
