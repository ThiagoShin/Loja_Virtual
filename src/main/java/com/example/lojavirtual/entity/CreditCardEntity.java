package com.example.lojavirtual.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CreditCard")
public class CreditCardEntity extends SuperEntity {

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date validateDate;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cvv;

    @OneToOne(targetEntity = OrderEntity.class, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    public CreditCardEntity() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
