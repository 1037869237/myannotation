package com.example.myannotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = {com.example.myannotation.entity.IBuy.class})
public class ConfigAop {
}
