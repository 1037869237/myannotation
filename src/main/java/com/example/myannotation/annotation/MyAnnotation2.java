package com.example.myannotation.annotation;

import com.example.myannotation.enumtest.TransactionModel;

import java.lang.annotation.*;

/**
 * 该注解可以用在类和接口，成员变量，方法上
 * 在运行期间保留注解
 * 可继承
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation2 {
    TransactionModel[] model() default TransactionModel.ReadWrite;
}
