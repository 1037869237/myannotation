package com.example.myannotation.controller;

import com.example.myannotation.annotation.MyAnnotation3;
import com.example.myannotation.annotation.MyLog;
import com.example.myannotation.entity.Boy;
import com.example.myannotation.entity.IBuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 踩坑：
 * boy和girl得放入到容器里面，加上component注解，才可以实现aop。
 */
@RestController
public class AnnotationController {
    @Autowired
    Boy boy;

    @MyAnnotation3(name = "liwenrui")
    private String name;

    @GetMapping("/aop")
    public String test(){
        return boy.buy();
    }

    @GetMapping("/aoparam")
    public String test1(){
        return boy.buy(67);
    }
    @GetMapping("/addlog")
    @MyLog
    public String test2(){
        return "test";
    }
}
