package com.example.lojavirtual.request;

import java.util.Date;

public class CreditCardRequest {
    private String number;
    private Date validateDate;
    private String name;
    private Integer cvv;

    public String getNumber() {
        return number;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public String getName() {
        return name;
    }

    public Integer getCvv() {
        return cvv;
    }
}
