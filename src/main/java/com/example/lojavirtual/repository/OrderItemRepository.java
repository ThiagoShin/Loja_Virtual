package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.OrderItemEntity;
import com.example.lojavirtual.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    Boolean existsByProduct(ProductEntity product);
}
