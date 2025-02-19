package com.sample.ecomm

import com.sample.ecomm.controller.OrderController
import com.sample.ecomm.model.Order
import com.sample.ecomm.service.OrderService
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class OrderControllerSpec extends Specification {

    private OrderController orderController

    private OrderService orderService = Mock()

    def setup() {
        orderController = new OrderController(orderService: orderService)
    }
    def "test getOrder"() {
        given:
        ResponseEntity<Order> responseEntity
        Long orderId = 1L
        Order order = Mock()
        order.getOrderId() >> orderId
        when:
        responseEntity = orderController.getOrder(orderId)
        then:
        1 * orderService.findOrder(orderId) >> Optional.of(order)
        responseEntity.getBody()
        responseEntity.getBody().getOrderId() == orderId
    }
}
