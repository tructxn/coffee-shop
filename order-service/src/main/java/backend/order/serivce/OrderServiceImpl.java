package backend.order.serivce;

import backend.order.dto.OrderResponse;
import backend.order.dto.OrderStatus;
import backend.order.entity.OrderEntity;
import backend.order.repository.OrderRedisRepository;
import backend.order.repository.OrderRepository;
import backend.order.utils.OrderMapperUtils;
import common.api.ResponseBuilder;
import common.api.ResponseStatus;
import common.exeption.DatabaseException;
import order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.OrderWaitingResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapperUtils orderMapperUtils;

    @Autowired
    private ResponseBuilder responseBuilder;

    @Autowired
    private OrderRedisRepository orderRedisRepository;

    @Override
    public OrderResponse getOrder(String orderId) {
        Optional<OrderEntity> orderEntityWraper = orderRepository.findById(orderId);
        if (orderEntityWraper.isEmpty()) {
            return null;
        }
        OrderEntity orderEntity = orderEntityWraper.get();
        Integer indexInQueue = 0;
        if (orderEntity.getStatus().equals(OrderStatus.PENDING.name())) {
            //Get index in queue from redis
            indexInQueue = Math.toIntExact(orderRedisRepository.getOrderIndex(orderEntity.getShopId(), orderEntity.getQueueId(), orderId));
            logger.info(" order {} have queue index {} ", orderId, indexInQueue);
        }

        Order order = orderEntity.toDto()
                .queueIndex(indexInQueue).build();
        return OrderResponse.builder()
                .data(order)
                .responseStatus(ResponseStatus.builder().resultCode(0).resultMessage("success").build())
                .build();
    }

    @Override
    public OrderResponse cancelOrder(String orderId) {
        return null;
    }

    @Override
    public OrderResponse saveOrder(Order body) {
        try {
            OrderEntity orderEntity = orderMapperUtils.buildNewOrderEntity(body);
            orderRepository.save(orderEntity);
            logger.info("save order {} successfully", orderEntity.getOrderId());
            orderRedisRepository.saveOrderToWaiting(body.getQueueId(), body.getShopId(), orderEntity.getOrderId());
            return OrderResponse.builder().data(orderEntity.toDto().build()).
                    responseStatus(responseBuilder.buildSuccessResponse()).build();
        } catch (Exception e) {
            logger.error("error ", e);
            return OrderResponse.builder().responseStatus(responseBuilder.buildResponse(new DatabaseException())).build();
        }
    }

    @Override
    public OrderWaitingResponse getWaitingOrder(Integer queueId, String shopId) {
        try {

            logger.info("start get waiting order for {} ", shopId);
            List<String> listOrder = orderRedisRepository.getProcessingOrder(shopId, queueId);

            if (listOrder == null || listOrder.isEmpty()) {
                logger.warn(" null or empty list order ");
                return OrderWaitingResponse.builder().responseStatus(responseBuilder.buildSuccessResponse()).build();
            }
            Iterable<OrderEntity> ordersIterator = orderRepository.findAllById(listOrder);
            if (ordersIterator == null) {
                logger.info("No order in waiting queue ");
                return OrderWaitingResponse.builder().responseStatus(responseBuilder.buildSuccessResponse()).build();

            }
            logger.info("list waiting order in queue {} shop {} is {}", queueId, shopId, listOrder.stream().collect(Collectors.joining(",")));
            List<Order> orders = StreamSupport.stream(ordersIterator.spliterator(), false).map(orderEntity -> orderEntity.toDto().build())
                    .collect(Collectors.toList());
            return OrderWaitingResponse.builder().data(orders).
                    responseStatus(responseBuilder.buildSuccessResponse()).build();
        } catch (Exception e) {
            logger.error("error ", e);
            return OrderWaitingResponse.builder().responseStatus(responseBuilder.buildResponse(new DatabaseException())).build();
        }
    }
}
