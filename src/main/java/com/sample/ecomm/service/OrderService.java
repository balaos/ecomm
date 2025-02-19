package com.sample.ecomm.service;

import com.sample.ecomm.model.*;
import com.sample.ecomm.repo.CustomerRepository;
import com.sample.ecomm.repo.OrderRepository;
import com.sample.ecomm.repo.ProductRepository;
import com.sample.ecomm.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Long createOrder(CreateOrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.Pending);

        List<OrderItem> orderItems = request.getItems().stream().map(itemDTO -> {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(product.getPrice());

            return orderItem;
        }).toList();

        BigDecimal totalAmount = orderItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalAmount(totalAmount);
        order.getItems().addAll(orderItems);

        Order order1 = orderRepository.save(order);

        return order1.getOrderId();
    }
}
