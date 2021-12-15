package com.example.lojavirtual.service;

import com.example.lojavirtual.dto.BrandDTO;
import com.example.lojavirtual.dto.CategoryDTO;
import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.ProductEntity;
import com.example.lojavirtual.dto.ProductDTO;
import com.example.lojavirtual.repository.BrandRepository;
import com.example.lojavirtual.repository.CategoryRepository;
import com.example.lojavirtual.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private List<ProductDTO> getProductList(List<ProductEntity> productEntityList) {

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (ProductEntity productEntity : productEntityList) {
            ProductDTO productDTO = new ProductDTO(productEntity);

            productDTOList.add(productDTO);
        }

//        for (int i = 0; i < productEntityList.size(); i++ ) {
//
//            ProductEntity productEntity =  productEntityList.get(i);
//            ProductDTO productDTO = new ProductDTO();
//            productDTO.setProductname(productEntity.getProductname());
//            productDTO.setCategory(productEntity.getCategory());
//            productDTO.setPrice(productEntity.getPrice());
//            productDTO.setDescription(productEntity.getDescription());
//
//            productDTOList.add(productDTO);
//        }

        return productDTOList;
    }

    public List<ProductDTO> getProduct() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        return getProductList(productEntityList);
    }

    public List<ProductDTO> getProductCategory(String category) {
        Optional <CategoryEntity> categoryEntity = categoryRepository.findByNameContainingIgnoreCase(category);
        List<ProductEntity> productEntityList = new ArrayList<>();

        if (categoryEntity.isPresent()) {
            productEntityList = productRepository.findAllByCategory(categoryEntity.get());
        }

        return getProductList(productEntityList);
    }

    public List<ProductDTO> getProductBrand(String brand) {
        Optional<BrandEntity> brandEntity = brandRepository.findByNameContainingIgnoreCase(brand);
        List<ProductEntity> productEntityList = new ArrayList<>();

        if (brandEntity.isPresent()) {
            productEntityList = productRepository.findAllByBrand(brandEntity.get());
        }

        return getProductList(productEntityList);
    }

    public List<ProductDTO> getProductBrandAndCategory(String brand, String category) {
        Optional<BrandEntity> brandEntity = brandRepository.findByNameContainingIgnoreCase(brand);
        Optional <CategoryEntity> categoryEntity = categoryRepository.findByNameContainingIgnoreCase(category);
        List<ProductEntity> productEntityList = new ArrayList<>();

        if (brandEntity.isPresent() && categoryEntity.isPresent()) {
            productEntityList = productRepository.findAllByBrandAndCategory(brandEntity.get(), categoryEntity.get());
        }

        return getProductList(productEntityList);
    }

    public List<BrandDTO> getBrandList() {
        List<BrandDTO> brandDTOList = new ArrayList<>();

        for (BrandEntity brandEntity : brandRepository.findAll()) {
            BrandDTO brandDTO = new BrandDTO(brandEntity);
            brandDTOList.add(brandDTO);
        }
        return brandDTOList;
    }

    public List<CategoryDTO> getCategoryList() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryRepository.findAll()) {
            CategoryDTO categoryDTO = new CategoryDTO(categoryEntity);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
