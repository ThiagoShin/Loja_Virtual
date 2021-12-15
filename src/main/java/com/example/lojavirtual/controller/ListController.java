package com.example.lojavirtual.controller;

import com.example.lojavirtual.dto.BrandDTO;
import com.example.lojavirtual.dto.CategoryDTO;
import com.example.lojavirtual.dto.ProductDTO;
import com.example.lojavirtual.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping("/products")
    public List<ProductDTO> products(){
        return listService.getProduct();
    }

    @GetMapping("/products/brand")
    public List<ProductDTO> productsBrands(@RequestParam String brand){
        return listService.getProductBrand(brand);
    }

    @GetMapping("/products/category")
    public List<ProductDTO> productsCategories(@RequestParam String category){
        return listService.getProductCategory(category);
    }

    @GetMapping("/products/category-brand")
    public List<ProductDTO> productsBrand(@RequestParam String brand, @RequestParam String category){
        return listService.getProductBrandAndCategory(brand, category);
    }

    @GetMapping("/brands")
    public List<BrandDTO> brands(){
        return listService.getBrandList();
    }

    @GetMapping("/categories")
    public List<CategoryDTO> categories (){
        return listService.getCategoryList();
    }
}

