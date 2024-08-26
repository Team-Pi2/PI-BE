package com.oasis.flowershop.domain.order.application.model;

import com.oasis.flowershop.domain.order.application.exception.CategoryNotFoundException;

import java.util.Arrays;

public enum Category {

    ALL("All"),
    씨앗("씨앗"),
    나무("나무"),
    꽃("꽃"),
    열매("열매");

    private String category;

    Category(String category){ this.category = category; }

    @Override
    public String toString(){ return this.category; }

    public static Category findCategory(String query){
        return Arrays.stream(Category.values())
                .filter(c->c.toString().equals(query))
                .findFirst()
                .orElseThrow(CategoryNotFoundException::new);
    }
}
