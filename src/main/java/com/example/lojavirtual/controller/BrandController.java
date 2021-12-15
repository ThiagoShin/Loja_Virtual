package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.BrandRequest;
import com.example.lojavirtual.service.BrandService;
import com.example.lojavirtual.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/register")
    public ResponseEntity<String> registerBrand(@RequestParam Long id, @RequestBody BrandRequest brandRequest) {
        int ret = permissionService.permissions(id);
        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.UNAUTHORIZED);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        Long retorno = brandService.registerBrand(brandRequest);

        if (retorno == 0L) {
            return new ResponseEntity<>("Marca já existe", HttpStatus.BAD_REQUEST);
        } else {
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("BrandID", Long.toString(retorno));
            return new ResponseEntity<>("Marca criada", responseHeader, HttpStatus.OK);
        }
    }
}
