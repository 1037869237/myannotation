package com.example.myannotation.annotation;

import com.example.myannotation.enumtest.TransactionModel;

import java.lang.annotation.*;

/**
 * 此注解可以用在方法上
 * 注解运行期间可以被保留
 * 不可被继承
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Myannotation1 {
    TransactionModel model() default TransactionModel.Read;
}
