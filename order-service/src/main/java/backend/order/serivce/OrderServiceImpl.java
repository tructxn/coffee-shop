package backend.order.serivce;

import exeption.ApiException;
import backend.order.dto.Order;
import backend.order.dto.OrderResponse;
import backend.order.entity.OrderEntity;
import backend.order.repository.OrderRepository;
import backend.order.utils.OrderMapperUtils;
import dto.response.ResponseBuilder;
import dto.response.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapperUtils orderMapperUtils;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderResponse getOrder(String orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isEmpty()) {
            return null;
        }

        Order order = orderEntity.get().toDto().build();
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
            return OrderResponse.builder().data(orderEntity.toDto().build()).
                    responseStatus(responseBuilder.buildSuccessResponse()).build();
        }catch (Exception e) {
            logger.error("error ", e);
            return OrderResponse.builder().responseStatus(responseBuilder.buildResponse(new ApiException(-1, "", 1))).build();
        }
    }
}
