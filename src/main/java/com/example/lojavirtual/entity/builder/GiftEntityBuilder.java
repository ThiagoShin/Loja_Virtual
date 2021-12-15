package com.example.lojavirtual.entity.builder;

import com.example.lojavirtual.entity.GiftEntity;

import java.time.LocalDateTime;

public final class GiftEntityBuilder {
    private final GiftEntity giftEntity;

    private GiftEntityBuilder() {
        giftEntity = new GiftEntity();
    }

    public static GiftEntityBuilder builder() {
        return new GiftEntityBuilder();
    }

    public GiftEntityBuilder withName(String name) {
        giftEntity.setName(name);
        return this;
    }

    public GiftEntityBuilder withValue(Integer value) {
        giftEntity.setValue(value);
        return this;
    }

    public GiftEntityBuilder withStart(LocalDateTime start) {
        giftEntity.setStart(start);
        return this;
    }

    public GiftEntityBuilder withFinish(LocalDateTime finish) {
        giftEntity.setFinish(finish);
        return this;
    }

    public GiftEntityBuilder withIsMultiple(Boolean isMultiple) {
        giftEntity.setIsMultiple(isMultiple);
        return this;
    }

    public GiftEntity build() {
        return giftEntity;
    }
}
