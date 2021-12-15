package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.CartItemEntity;
import com.example.lojavirtual.entity.ProductEntity;

public final class CartItemEntityBuilder {

    private final CartItemEntity cartItemEntity;

    private CartItemEntityBuilder() {
        cartItemEntity = new CartItemEntity();
    }

    public static CartItemEntityBuilder builder() {
        return new CartItemEntityBuilder();
    }

    public CartItemEntityBuilder withCart(CartEntity cart) {
        cartItemEntity.setCart(cart);
        return this;
    }

    public CartItemEntityBuilder withProduct(ProductEntity product) {
        cartItemEntity.setProduct(product);
        return this;
    }

    public CartItemEntityBuilder withQuantity(Integer quantity) {
        cartItemEntity.setQuantity(quantity);
        return this;
    }

    public CartItemEntity build() {
        return cartItemEntity;
    }
}
