package com.example.lojavirtual.dto;

import com.example.lojavirtual.entity.CategoryEntity;

public class CategoryDTO {
    private String name;

    public CategoryDTO(CategoryEntity category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
