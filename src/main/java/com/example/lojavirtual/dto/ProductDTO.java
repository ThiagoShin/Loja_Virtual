package com.example.lojavirtual.dto;

import com.example.lojavirtual.entity.ProductEntity;

import java.math.BigDecimal;

public class ProductDTO {

    private String productName;
    private String description;
    private BigDecimal price;
    private int quantity;
    private CategoryDTO category;
    private BrandDTO brand;

    public ProductDTO(ProductEntity product) {
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.category = new CategoryDTO(product.getCategory());
        this.brand = new BrandDTO(product.getBrand());
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }
}
