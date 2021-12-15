package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.OrderEntity;
import com.example.lojavirtual.entity.OrderItemEntity;
import com.example.lojavirtual.entity.ProductEntity;

public final class OrderItemEntityBuilder {
    private final OrderItemEntity orderItemEntity;

    private OrderItemEntityBuilder() {
        orderItemEntity = new OrderItemEntity();
    }

    public static OrderItemEntityBuilder builder() {
        return new OrderItemEntityBuilder();
    }

    public OrderItemEntityBuilder withOrder(OrderEntity order) {
        orderItemEntity.setOrder(order);
        return this;
    }

    public OrderItemEntityBuilder withProduct(ProductEntity product) {
        orderItemEntity.setProduct(product);
        return this;
    }

    public OrderItemEntityBuilder withQuantity(Integer quantity) {
        orderItemEntity.setQuantity(quantity);
        return this;
    }

    public OrderItemEntity build() {
        return orderItemEntity;
    }
}
