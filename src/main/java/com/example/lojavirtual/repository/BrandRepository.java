package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository <BrandEntity, Long> {
    Boolean existsByNameIgnoreCase(String name);

    Optional<BrandEntity> findByNameContainingIgnoreCase(String brand);
}
