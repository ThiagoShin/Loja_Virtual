package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.ProductRequest;
import com.example.lojavirtual.service.PermissionService;
import com.example.lojavirtual.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/register")
    public ResponseEntity<String> registerProduct(@RequestParam Long userId, @RequestBody ProductRequest productRequest) {

        int ret = permissionService.permissions(userId);

        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.UNAUTHORIZED);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        int retorno = productService.registerProduct(productRequest);

        if (retorno == -1) {
            return new ResponseEntity<>("Nome do produto já existe", HttpStatus.BAD_REQUEST);
        } else if (retorno == -2) {
            return new ResponseEntity<>("Marca não existe", HttpStatus.BAD_REQUEST);
        } else if (retorno == -3) {
            return new ResponseEntity<>("Categoria não existe", HttpStatus.BAD_REQUEST);
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("ProductID", Long.toString(retorno));
        return new ResponseEntity<>("Produto Criado", responseHeader, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(@RequestParam Long userId, @RequestBody ProductRequest productRequest,
                                                @PathVariable Long productId) {

        int ret = permissionService.permissions(userId);

        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.BAD_REQUEST);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        int retorno = productService.updateProduct(productId, productRequest);

        if (retorno == 0) {
            return new ResponseEntity<>("Produto inexistente", HttpStatus.BAD_REQUEST);
        } else if (retorno == -1) {
            return new ResponseEntity<>("Nome do produto já existe", HttpStatus.BAD_REQUEST);
        } else if (retorno == -2) {
            return new ResponseEntity<>("Marca não existe", HttpStatus.BAD_REQUEST);
        } else if (retorno == -3) {
            return new ResponseEntity<>("Categoria não existe", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Dados do produto alterados", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@RequestParam Long userId, @PathVariable Long productId) {

        int ret = permissionService.permissions(userId);

        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.BAD_REQUEST);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        int retorno = productService.deleteProduct(productId);

        if (retorno == 0) {
            return new ResponseEntity<>("Produto inexistente", HttpStatus.BAD_REQUEST);
        } else if (retorno == 2) {
            return new ResponseEntity<>("Produto não pode ser excluído", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Produto excluído", HttpStatus.OK);
    }
}
