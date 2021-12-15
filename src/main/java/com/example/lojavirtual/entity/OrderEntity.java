package com.example.lojavirtual.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class OrderEntity extends SuperEntity {

    @ManyToOne(targetEntity = UserEntity.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(targetEntity = GiftEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "gift_id")
    private GiftEntity gift;

    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private String deliveryAddress;
    private String billingAddress;

    @OneToMany(targetEntity = OrderItemEntity.class, mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItemEntity> items;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    private CreditCardEntity card;

    public OrderEntity() {
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public GiftEntity getGift() {
        return gift;
    }

    public void setGift(GiftEntity gift) {
        this.gift = gift;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public CreditCardEntity getCard() {
        return card;
    }

    public void setCard(CreditCardEntity card) {
        this.card = card;
    }
}
