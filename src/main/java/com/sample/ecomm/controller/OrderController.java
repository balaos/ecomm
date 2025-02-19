package com.sample.ecomm.controller;

import com.sample.ecomm.model.Order;
import com.sample.ecomm.model.Product;
import com.sample.ecomm.request.CreateOrderRequest;
import com.sample.ecomm.service.OrderService;
import com.sample.ecomm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@Tag(name = "Order Controller" , description = "Order Controller")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    @Operation(summary = "Get Order List", description = "Order List of all orders")
    public ResponseEntity<List<Order>> getOrderList() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @PostMapping("/add")
    @Operation(summary = "Add Order", description = "Create new order")
    public ResponseEntity<Long> addOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok().body(orderService.createOrder(createOrderRequest));
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "Get Order", description = "Get order for the given order id")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Optional<Order> orderOptional =  orderService.findOrder(orderId);
        return ResponseEntity.ok().body(!orderOptional.isEmpty() ? orderOptional.get() : null);
    }
}
