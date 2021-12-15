package com.example.lojavirtual.request;

import java.time.LocalDateTime;

public class GiftRequest {

    private String name;
    private Integer value;
    private LocalDateTime start;
    private LocalDateTime finish;
    private final Boolean isMultiple = false;

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Boolean getIsMultiple() {
        return isMultiple;
    }
}
