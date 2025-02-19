package com.sample.ecomm.request;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private Long customerId;
    private List<OrderItemDTO> items;

    @Getter
    @Setter
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
        private BigDecimal price;
    }
}

