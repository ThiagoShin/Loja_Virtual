package com.example.lojavirtual.dto.order;

import com.example.lojavirtual.dto.GiftDTO;
import com.example.lojavirtual.dto.UserDTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

    private UserDTO user;
    private List<OrderItemDTO> items;
    private String billingAddress;
    private String deliveryAddress;
    private GiftDTO gift;
    private BigDecimal totalAmount;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public GiftDTO getGift() {
        return gift;
    }

    public void setGift(GiftDTO gift) {
        this.gift = gift;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
