package com.example.lojavirtual.request;

public class CartRequest {

    private Long productId;
    private final Integer quantity = 1;

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        if (quantity <= 0) {
            return 1;
        }

        return quantity;
    }
}
