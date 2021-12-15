package com.example.lojavirtual.service;

import java.util.ArrayList;
import java.util.List;

public class AuthSingleton {

    public static final AuthSingleton instance = new AuthSingleton();

    private final List<Long> users = new ArrayList<>();

    private AuthSingleton() {
    }

    public static AuthSingleton getSingleton() {
        return instance;
    }

    public void registerAuth(Long id) {
        if (!isAuthenticated(id)) {
            users.add(id);
        }
    }

    public Boolean isAuthenticated(Long id) {
        return users.contains(id);
    }
}
