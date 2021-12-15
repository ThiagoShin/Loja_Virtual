package com.example.lojavirtual.entity;

import javax.persistence.*;

@Entity
public class UserEntity extends SuperEntity {

    @Column(name = "Password", nullable = false)
    private String pass;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "Residencialphone")
    private String residencialPhone;

    @Column(name = "Comercialphone")
    private String comercialPhone;

    @Column(name = "Cellphone")
    private String cellPhone;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "ResidencialAddress")
    private String residencialAddress;

    @Column(name = "ComercialAddress")
    private String comercialAddress;

    @Column(name = "Permission")
    private String permission;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CartEntity cart;

    public UserEntity() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getResidencialPhone() {
        return residencialPhone;
    }

    public void setResidencialPhone(String residencialPhone) {
        this.residencialPhone = residencialPhone;
    }

    public String getComercialPhone() {
        return comercialPhone;
    }

    public void setComercialPhone(String comercialPhone) {
        this.comercialPhone = comercialPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidencialAddress() {
        return residencialAddress;
    }

    public void setResidencialAddress(String residencialAddress) {
        this.residencialAddress = residencialAddress;
    }

    public String getComercialAddress() {
        return comercialAddress;
    }

    public void setComercialAddress(String comercialAddress) {
        this.comercialAddress = comercialAddress;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}