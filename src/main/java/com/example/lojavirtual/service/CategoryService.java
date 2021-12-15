package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.builder.CategoryEntityBuilder;
import com.example.lojavirtual.repository.CategoryRepository;
import com.example.lojavirtual.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Long registerCategory (CategoryRequest categoryRequest){

        if (categoryRepository.existsByNameIgnoreCase(categoryRequest.getName())){
            return 0L;
        }

        CategoryEntity categoryEntity = CategoryEntityBuilder.builder()
                .withName(categoryRequest.getName())
                .build();

        categoryRepository.save(categoryEntity);

        return categoryEntity.getId();
    }
}
