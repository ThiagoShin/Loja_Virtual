package com.example.lojavirtual.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class GiftEntity extends SuperEntity {

    private String name;

    private Integer value;

    private Boolean isMultiple = false;

    private LocalDateTime start;

    private LocalDateTime finish;

//    @ManyToOne(targetEntity = CategoryEntity.class, optional = false)
//    @JoinColumn(name = "category_id")
//    private CategoryEntity category;

    public GiftEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

//    public CategoryEntity getCategory() {
//        return category;
//    }
//
//    public void setCategory(CategoryEntity category) {
//        this.category = category;
//    }

    public Boolean getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Boolean multiple) {
        isMultiple = multiple;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

}
