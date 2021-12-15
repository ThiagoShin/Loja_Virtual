package com.example.lojavirtual.dto;

import com.example.lojavirtual.entity.BrandEntity;

public class BrandDTO {
    private String name;

    public BrandDTO(BrandEntity brand) {
        this.name = brand.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
