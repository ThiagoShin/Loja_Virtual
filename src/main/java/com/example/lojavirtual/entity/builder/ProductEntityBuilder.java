package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.ProductEntity;

import java.math.BigDecimal;

public final class ProductEntityBuilder {

    private final ProductEntity productEntity;

    private ProductEntityBuilder() {
        productEntity = new ProductEntity();
    }

    public static ProductEntityBuilder builder() {
        return new ProductEntityBuilder();
    }

    public ProductEntityBuilder withProductName(String productName) {
        productEntity.setProductName(productName);
        return this;
    }

    public ProductEntityBuilder withQuantity(Integer quantity) {
        productEntity.setQuantity(quantity);
        return this;
    }

    public ProductEntityBuilder withDescription(String description) {
        productEntity.setDescription(description);
        return this;
    }

    public ProductEntityBuilder withPrice(BigDecimal price) {
        productEntity.setPrice(price);
        return this;
    }

    public ProductEntityBuilder withCategory(CategoryEntity category) {
        productEntity.setCategory(category);
        return this;
    }

    public ProductEntityBuilder withBrand(BrandEntity brand) {
        productEntity.setBrand(brand);
        return this;
    }

    public ProductEntity build() {
        return productEntity;
    }
}
