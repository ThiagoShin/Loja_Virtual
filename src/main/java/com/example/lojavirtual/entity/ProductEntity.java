package com.example.lojavirtual.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ProductEntity extends SuperEntity {

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(targetEntity = CategoryEntity.class, optional = false)
    private CategoryEntity category;

    @ManyToOne(targetEntity = BrandEntity.class, optional = false)
    private BrandEntity brand;

    public ProductEntity() {}

    public ProductEntity(String productName, String description, BigDecimal price, CategoryEntity category, BrandEntity brand, Integer quantity) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
