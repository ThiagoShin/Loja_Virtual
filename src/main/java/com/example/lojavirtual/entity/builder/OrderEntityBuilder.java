package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.GiftEntity;
import com.example.lojavirtual.entity.OrderEntity;
import com.example.lojavirtual.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class OrderEntityBuilder {
    private final OrderEntity orderEntity;

    private OrderEntityBuilder() {
        orderEntity = new OrderEntity();
    }

    public static OrderEntityBuilder builder() {
        return new OrderEntityBuilder();
    }

    public OrderEntityBuilder withUser(UserEntity user) {
        orderEntity.setUser(user);
        return this;
    }

    public OrderEntityBuilder withGift(GiftEntity gift) {
        orderEntity.setGift(gift);
        return this;
    }

    public OrderEntityBuilder withTotalAmount(BigDecimal totalAmount) {
        orderEntity.setTotalAmount(totalAmount);
        return this;
    }

    public OrderEntityBuilder withOrderDate(LocalDateTime orderDate) {
        orderEntity.setOrderDate(orderDate);
        return this;
    }

    public OrderEntityBuilder withDeliveryAddress(String deliveryAddress) {
        orderEntity.setDeliveryAddress(deliveryAddress);
        return this;
    }

    public OrderEntityBuilder withBillingAddress(String billingAddress ) {
        orderEntity.setBillingAddress(billingAddress);
        return this;
    }

    public OrderEntity build() {
        return orderEntity;
    }
}
