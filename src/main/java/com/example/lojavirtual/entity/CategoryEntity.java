package com.example.lojavirtual.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CategoryEntity extends SuperEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "category")
    private List<ProductEntity> products;

    public CategoryEntity() {
    }

    public CategoryEntity(String name, List<ProductEntity> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
