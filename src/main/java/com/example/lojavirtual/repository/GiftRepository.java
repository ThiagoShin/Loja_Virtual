package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiftRepository extends JpaRepository<GiftEntity, Long> {

    Boolean existsByNameIgnoreCase(String name);

    Optional<GiftEntity> findByNameIgnoreCase(String coupon);
}
