package com.sample.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

@Data
@RedisHash("my-cart")
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cart {
    @Id
    String id;
    int noOfitems;
    double total;
}
