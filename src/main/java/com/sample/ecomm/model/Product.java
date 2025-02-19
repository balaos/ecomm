package com.sample.ecomm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Product {

    @Id
    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private int categoryId;
    private LocalDateTime createdAt;

}
