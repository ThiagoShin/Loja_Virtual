package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;

public final class CategoryEntityBuilder {
    private final CategoryEntity categoryEntity;

    private CategoryEntityBuilder() {
        categoryEntity = new CategoryEntity();
    }

    public static CategoryEntityBuilder builder() {
        return new CategoryEntityBuilder();
    }

    public CategoryEntityBuilder withName(String name) {
        categoryEntity.setName(name);
        return this;
    }

    public CategoryEntityBuilder withProducts(List<ProductEntity> products) {
        categoryEntity.setProducts(products);
        return this;
    }

    public CategoryEntity build() {
        return categoryEntity;
    }
}
