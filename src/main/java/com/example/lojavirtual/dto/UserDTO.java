package com.example.lojavirtual.dto;

public class UserDTO {
    private String name;
    private String CPF;
    private String email;
    private String cellPhone;
    private String residencialAddress;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getResidencialAddress() {
        return residencialAddress;
    }

    public void setResidencialAddress(String residencialAddress) {
        this.residencialAddress = residencialAddress;
    }

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

}
