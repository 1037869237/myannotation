package com.example.myannotation.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注解+aop实现 日志的添加
 */
@Aspect
@Component
public class LogAspectJ {
    //在添加这个注解的地方都会被后面增强
    @Pointcut("@annotation(com.example.myannotation.annotation.MyLog)")
    public  void Point(){};

    @Before("Point()")
    public void addLog(){
        System.out.println("add....LOG");
    }
}
