package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.GiftEntity;
import com.example.lojavirtual.entity.builder.GiftEntityBuilder;
import com.example.lojavirtual.repository.GiftRepository;
import com.example.lojavirtual.request.GiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public Long registerGift(GiftRequest giftRequest) {

        if (giftRepository.existsByNameIgnoreCase(giftRequest.getName())) {
            return -1L;
        }

        GiftEntity gift = GiftEntityBuilder.builder()
                .withName(giftRequest.getName())
                .withValue(giftRequest.getValue())
                .withStart(giftRequest.getStart())
                .withFinish(giftRequest.getFinish())
                .withIsMultiple(giftRequest.getIsMultiple())
                .build();

        giftRepository.save(gift);

        return gift.getId();
    }
}
