package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.OrderRequest;
import com.example.lojavirtual.service.OrderService;
import com.example.lojavirtual.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/register")
    public ResponseEntity<?> registerOrder(@RequestParam(required = false) Long userId, @RequestBody OrderRequest orderRequest) {

        if (permissionService.isLogged(userId)) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.BAD_REQUEST);
        }

        Long ret = orderService.registerOrder(userId, orderRequest);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("OrderID", Long.toString(ret));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
