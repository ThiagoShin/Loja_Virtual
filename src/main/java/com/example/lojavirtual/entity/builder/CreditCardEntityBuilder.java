package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.CreditCardEntity;
import com.example.lojavirtual.entity.OrderEntity;

import java.util.Date;

public final class CreditCardEntityBuilder {
    private final CreditCardEntity creditCardEntity;

    private CreditCardEntityBuilder() {
        creditCardEntity = new CreditCardEntity();
    }

    public static CreditCardEntityBuilder builder() {
        return new CreditCardEntityBuilder();
    }

    public CreditCardEntityBuilder withNumber(String number) {
        creditCardEntity.setNumber(number);
        return this;
    }

    public CreditCardEntityBuilder withValidateDate(Date validateDate) {
        creditCardEntity.setValidateDate(validateDate);
        return this;
    }

    public CreditCardEntityBuilder withName(String name) {
        creditCardEntity.setName(name);
        return this;
    }

    public CreditCardEntityBuilder withCvv(Integer cvv) {
        creditCardEntity.setCvv(cvv);
        return this;
    }

    public CreditCardEntityBuilder withOrder(OrderEntity order) {
        creditCardEntity.setOrder(order);
        return this;
    }

    public CreditCardEntity build() {
        return creditCardEntity;
    }
}
