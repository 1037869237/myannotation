package com.example.myannotation.entity;

import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {
    @Override
    public String buy() {
        System.out.println("男孩买游戏机");
        return "游戏机";
    }

    @Override
    public String buy(double price) {
        System.out.println(String.format("男孩花了%s元买了ps4",price));
        return "ps4";
    }
}
