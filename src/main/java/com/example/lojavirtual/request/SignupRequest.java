package com.example.lojavirtual.request;

public class SignupRequest {
    private String name;
    private String CPF;
    private String email;
    private String pass;
    private String permission;
    private String residencialphone;
    private String comercialphone;
    private String cellphone;
    private String residencialaddress;
    private String comercialaddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResidencialphone() {
        return residencialphone;
    }

    public void setResidencialphone(String residencialphone) {
        this.residencialphone = residencialphone;
    }

    public String getComercialphone() {
        return comercialphone;
    }

    public void setComercialphone(String comercialphone) {
        this.comercialphone = comercialphone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getResidencialaddress() {
        return residencialaddress;
    }

    public void setResidencialaddress(String residencialaddress) {
        this.residencialaddress = residencialaddress;
    }

    public String getComercialaddress() {
        return comercialaddress;
    }

    public void setComercialaddress(String comercialaddress) {
        this.comercialaddress = comercialaddress;
    }
}
