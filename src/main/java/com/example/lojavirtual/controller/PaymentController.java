package com.example.lojavirtual.controller;

import com.example.lojavirtual.dto.order.OrderDTO;
import com.example.lojavirtual.service.PaymentService;
import com.example.lojavirtual.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/{orderId}")
    public ResponseEntity<?> payment(@PathVariable Long orderId, @RequestParam Long userId){

        if (permissionService.isLogged(userId)) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.BAD_REQUEST);
        }

        OrderDTO orderDTO = paymentService.payment(orderId);

        return new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
    }
}
