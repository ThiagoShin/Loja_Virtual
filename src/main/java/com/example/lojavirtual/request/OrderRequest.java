package com.example.lojavirtual.request;

public class OrderRequest {

    private final String coupon = null;
    private String deliveryAddress;
    private CreditCardRequest card;
    private String billingAddress;

    public String getCoupon() {
        return coupon;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public CreditCardRequest getCard() {
        return card;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

}
