package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;

public final class BrandEntityBuilder {
    private final BrandEntity brandEntity;

    private BrandEntityBuilder() {
        brandEntity = new BrandEntity();
    }

    public static BrandEntityBuilder builder() {
        return new BrandEntityBuilder();
    }

    public BrandEntityBuilder withName(String name) {
        brandEntity.setName(name);
        return this;
    }

    public BrandEntityBuilder withProducts(List<ProductEntity> products) {
        brandEntity.setProducts(products);
        return this;
    }

    public BrandEntityBuilder withCreatedAt(LocalDateTime createdAt) {
        brandEntity.setCreatedAt(createdAt);
        return this;
    }

    public BrandEntityBuilder withUpdatedAt(LocalDateTime updatedAt) {
        brandEntity.setUpdatedAt(updatedAt);
        return this;
    }

    public BrandEntity build() {
        return brandEntity;
    }
}
