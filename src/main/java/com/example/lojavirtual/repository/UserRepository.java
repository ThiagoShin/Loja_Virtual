package com.example.lojavirtual.repository;

import com.example.lojavirtual.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findByEmailAndPass(String email, String pass);

    boolean existsByCpf(String cpf);
}
