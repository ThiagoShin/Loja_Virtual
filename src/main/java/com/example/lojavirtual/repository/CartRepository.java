package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findByRemoteIp(String ip);

    CartEntity getByUser(UserEntity userLogged);
}
