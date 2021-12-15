package com.example.lojavirtual.controller;


import com.example.lojavirtual.request.CategoryRequest;
import com.example.lojavirtual.service.CategoryService;
import com.example.lojavirtual.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCategory(@RequestParam Long id, @RequestBody CategoryRequest categoryRequest) {
        int ret = permissionService.permissions(id);
        if (ret == 0) {
            return new ResponseEntity<>("Usuário não realizou login", HttpStatus.BAD_REQUEST);
        } else if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado", HttpStatus.FORBIDDEN);
        }

        Long retorno = categoryService.registerCategory(categoryRequest);
        if (retorno == 0L) {
            return new ResponseEntity<>("Categoria já existe", HttpStatus.BAD_REQUEST);
        } else {
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("CategoryID", Long.toString(retorno));
            return new ResponseEntity<>("Categoria criada", responseHeader, HttpStatus.OK);
        }
    }
}
