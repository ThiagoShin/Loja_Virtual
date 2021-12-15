package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.LoginRequest;
import com.example.lojavirtual.request.SignupRequest;
import com.example.lojavirtual.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {

        Long token = authService.login(user);

        if (token == 0) {
            return new ResponseEntity<>("Usuário Não Encontrado", HttpStatus.NOT_FOUND);
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("UserID", token.toString());

        return new ResponseEntity<>("Login efetuado", responseHeader, HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest user) {

        int result = authService.signup(user);

        if (result == 1) {
            //NOME
            return new ResponseEntity<>("Nome de usuário inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 2) {
            //CPF
            return new ResponseEntity<>("CPF inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 3) {
            //EMAIL
            return new ResponseEntity<>("Email inválido", HttpStatus.BAD_REQUEST);

        } else if (result == 4) {
            return new ResponseEntity<>("Senha inválido", HttpStatus.BAD_REQUEST);
            //SENHA
        } else if (result == 5) {
            return new ResponseEntity<>("CPF Cadastrado", HttpStatus.BAD_REQUEST);
        } else if (result == 6) {
            return new ResponseEntity<>("Endereço Comercial inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 7) {
            return new ResponseEntity<>("Endereço Residencial inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 8) {
            return new ResponseEntity<>("Telefone Comercial inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 9) {
            return new ResponseEntity<>("Telefone Residência inválido", HttpStatus.BAD_REQUEST);
        } else if (result == 10) {
            return new ResponseEntity<>("Telefone pessoal inválido", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Cadastro efetuado", HttpStatus.CREATED);
    }
}
