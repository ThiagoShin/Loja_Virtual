package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.UserEntity;

public final class UserEntityBuilder {
    private UserEntity userEntity;

    private UserEntityBuilder() {
        userEntity = new UserEntity();
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public UserEntityBuilder withId(Long id) {
        userEntity.setId(id);
        return this;
    }

    public UserEntityBuilder withPass(String pass) {
        userEntity.setPass(pass);
        return this;
    }

    public UserEntityBuilder withName(String name) {
        userEntity.setName(name);
        return this;
    }

    public UserEntityBuilder withCPF(String cpf) {
        userEntity.setCpf(cpf);
        return this;
    }

    public UserEntityBuilder withResidencialPhone(String residencialPhone) {
        userEntity.setResidencialPhone(residencialPhone);
        return this;
    }

    public UserEntityBuilder withComercialPhone(String comercialPhone) {
        userEntity.setComercialPhone(comercialPhone);
        return this;
    }

    public UserEntityBuilder withCellPhone(String cellPhone) {
        userEntity.setCellPhone(cellPhone);
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        userEntity.setEmail(email);
        return this;
    }

    public UserEntityBuilder withResidencialAddress(String residencialAddress) {
        userEntity.setResidencialAddress(residencialAddress);
        return this;
    }

    public UserEntityBuilder withComercialAddress(String comercialAddress) {
        userEntity.setComercialAddress(comercialAddress);
        return this;
    }

    public UserEntityBuilder withPermission(String permission) {
        userEntity.setPermission(permission);
        return this;
    }

    public UserEntity build() {
        return userEntity;
    }
}
