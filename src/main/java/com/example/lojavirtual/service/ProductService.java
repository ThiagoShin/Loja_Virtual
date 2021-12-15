package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.CategoryEntity;
import com.example.lojavirtual.entity.SuperEntity;
import com.example.lojavirtual.entity.builder.ProductEntityBuilder;
import com.example.lojavirtual.entity.ProductEntity;
import com.example.lojavirtual.repository.BrandRepository;
import com.example.lojavirtual.repository.CategoryRepository;
import com.example.lojavirtual.repository.OrderItemRepository;
import com.example.lojavirtual.repository.ProductRepository;
import com.example.lojavirtual.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    public int registerProduct(ProductRequest productRequest) {
        if (productRepository.existsByProductNameIgnoreCase(productRequest.getProductName())) {
            return -1;
        }

        Optional<BrandEntity> brandEntity = brandRepository.findById(productRequest.getBrandId());
        if (brandEntity.isEmpty()) {
            return -2;
        }

        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(productRequest.getCategoryId());
        if (categoryEntity.isEmpty()) {
            return -3;
        }

        ProductEntity productEntity = ProductEntityBuilder.builder()
                .withProductName(productRequest.getProductName())
                .withBrand(brandEntity.get())
                .withCategory(categoryEntity.get())
                .withDescription(productRequest.getDescription())
                .withPrice(productRequest.getPrice())
                .withQuantity(productRequest.getQuantity())
                .build();

        productRepository.save(productEntity);
        return productEntity.getId().intValue();
    }

    public int updateProduct(Long id, ProductRequest productRequest) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if (productEntity.isEmpty()) {
            return 0;
        }

        if (!productEntity.get().getProductName().equalsIgnoreCase(productRequest.getProductName())) {
            if (productRepository.existsByProductNameIgnoreCase(productRequest.getProductName())) {
                return -1;
            }
        }

        Optional<BrandEntity> brandEntity = brandRepository.findById(productRequest.getBrandId());
        if (brandEntity.isEmpty()) {
            return -2;
        }

        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(productRequest.getCategoryId());
        if (categoryEntity.isEmpty()) {
            return -3;
        }

        ProductEntity product = productEntity.get();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setBrand(brandEntity.get());
        product.setCategory(categoryEntity.get());

        productRepository.save(product);

        return 1;
    }

    public int deleteProduct(Long productId) {

        Optional<ProductEntity> productEntity = productRepository.findById(productId);

        if (productEntity.isEmpty()) {
            return 0;
        }

        ProductEntity product = productEntity.get();

        if (orderItemRepository.existsByProduct(product)) {
            return 2;
        }

        productRepository.delete(product);

        return 1;
    }
}
