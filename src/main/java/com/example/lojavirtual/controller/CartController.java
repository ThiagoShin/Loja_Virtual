package com.example.lojavirtual.controller;

import com.example.lojavirtual.request.CartRequest;
import com.example.lojavirtual.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CartRequest cartRequest, @RequestParam(required = false) Long userId) {

        int ret = cartService.add(cartRequest, userId);

        if(ret == 1) {
            return new ResponseEntity<>("Produto não existe na Loja", HttpStatus.NOT_FOUND);
        }else if (ret == 2) {
            return new ResponseEntity<>("Produto já existe no carrinho", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Item adicionado ao carrinho", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody CartRequest cartRequest, @RequestParam(required = false) Long userId) {

        int ret = cartService.update(cartRequest, userId);

        if(ret == 1) {
            return new ResponseEntity<>("Produto não existe na Loja", HttpStatus.NOT_FOUND);
        }else if (ret == 2) {
            return new ResponseEntity<>("Não existe o produto dentro do carrinho", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Quantidade do produto atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody CartRequest cartRequest, @RequestParam(required = false) Long userId) {

        int ret = cartService.delete(cartRequest, userId);

        if(ret == 1) {
            return new ResponseEntity<>("Produto não existe na Loja", HttpStatus.NOT_FOUND);
        }else if (ret == 2) {
            return new ResponseEntity<>("Não existe o produto dentro do carrinho", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Produto deletado", HttpStatus.OK);
    }

}
