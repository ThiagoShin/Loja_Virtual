package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.GiftRequest;
import com.example.lojavirtual.service.GiftService;
import com.example.lojavirtual.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gift")
public class GiftController {

    @Autowired
    private PermissionService permissionService;

    private GiftService giftService;

    @PostMapping("/register")
    public ResponseEntity<String> registerGift(@RequestParam Long userId, @RequestBody GiftRequest gift) {
        int ret = permissionService.permissions(userId);
        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.UNAUTHORIZED);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        Long retorno = giftService.registerGift(gift);

        if (retorno == -1) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        } else {
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("GiftID", Long.toString(retorno));

            return new ResponseEntity<>("", responseHeader, HttpStatus.CREATED);
        }
    }
}
