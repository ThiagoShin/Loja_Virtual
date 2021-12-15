package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Boolean existsByNameIgnoreCase(String name);

    Optional<CategoryEntity> findByNameContainingIgnoreCase(String name);
}
