package com.example.lojavirtual.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItemEntity extends SuperEntity {

    @ManyToOne(targetEntity = CartEntity.class, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cart;

    @ManyToOne(targetEntity = ProductEntity.class, optional = false)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer quantity;

    public CartItemEntity() {
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
