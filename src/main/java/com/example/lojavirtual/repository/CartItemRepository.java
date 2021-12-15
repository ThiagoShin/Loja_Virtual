package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.CartItemEntity;
import com.example.lojavirtual.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {

    Optional<CartItemEntity> findByCartAndProduct(CartEntity cart, ProductEntity product);
}
