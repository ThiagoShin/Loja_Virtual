package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.UserEntity;
import com.example.lojavirtual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private UserRepository userRepository;

    public boolean isLogged (Long id) {
        AuthSingleton authSingleton = AuthSingleton.getSingleton();
        return authSingleton.isAuthenticated(id);
    }

    public int permissions(Long id) {
        AuthSingleton authSingleton = AuthSingleton.getSingleton();
        if (!authSingleton.isAuthenticated(id)) {
            return 0;
        } else {
            if (!checkPermission(id)) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    private boolean checkPermission(Long userID) {
        Optional<UserEntity> ret = userRepository.findById(userID);

        if (ret.isPresent()) {
            if (ret.get().getPermission().equals("Vendedor")) {
                return true;
            }
        }

        return false;
    }
}
