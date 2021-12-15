package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.BrandEntity;
import com.example.lojavirtual.entity.builder.BrandEntityBuilder;
import com.example.lojavirtual.repository.BrandRepository;
import com.example.lojavirtual.request.BrandRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Long registerBrand (BrandRequest brandRequest){

        if (brandRepository.existsByNameIgnoreCase(brandRequest.getName())){
            return 0L;
        }

        BrandEntity brandEntity = BrandEntityBuilder.builder()
                .withName(brandRequest.getName())
                .build();

        brandRepository.save(brandEntity);

        return brandEntity.getId();
    }
}
