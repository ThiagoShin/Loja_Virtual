package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory(CategoryEntity category);

    List<ProductEntity> findAllByBrand(BrandEntity brand);

    List<ProductEntity> findAllByBrandAndCategory(BrandEntity brand, CategoryEntity category);

    Boolean existsByProductNameIgnoreCase(String productName);
}
