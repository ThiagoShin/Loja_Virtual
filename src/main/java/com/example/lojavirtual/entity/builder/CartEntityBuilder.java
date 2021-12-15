package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.CartItemEntity;
import com.example.lojavirtual.entity.UserEntity;

import java.util.List;

public final class CartEntityBuilder {

    private final CartEntity cartEntity;

    private CartEntityBuilder() {
        cartEntity = new CartEntity();
    }

    public static CartEntityBuilder builder() {
        return new CartEntityBuilder();
    }

    public CartEntityBuilder withUser(UserEntity user) {
        cartEntity.setUser(user);
        return this;
    }

    public CartEntityBuilder withRemoteIp(String remoteIp) {
        cartEntity.setRemoteIp(remoteIp);
        return this;
    }

    public CartEntityBuilder withItems(List<CartItemEntity> items) {
        cartEntity.setItems(items);
        return this;
    }

    public CartEntity build() {
        return cartEntity;
    }
}
