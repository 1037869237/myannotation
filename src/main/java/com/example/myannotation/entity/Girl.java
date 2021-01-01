package com.example.myannotation.entity;

import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy{
    @Override
    public String buy() {
        System.out.println("女孩买了个洋娃娃");
        return "娃娃";
    }

    @Override
    public String buy(double price) {
        return null;
    }
}
