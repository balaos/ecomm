package com.sample.ecomm.controller;

import com.sample.ecomm.model.Cart;
import com.sample.ecomm.repo.RedisRepo;
import com.sample.ecomm.request.CreateOrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Controller" , description = "Cart Controller")
public class CartController {

    @Autowired
    private RedisRepo redisRepo;

    @PostMapping("/add")
    @Operation(summary = "Cart Order", description = "Create new order")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
        redisRepo.save(cart);
        return ResponseEntity.ok().body("Success");
    }
}
