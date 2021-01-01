package com.example.myannotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Aspect //切面
@Component
/**
 * around aaa.......
 * before
 * 男孩买游戏机
 * afterreturn
 * after
 * around bbb.......
 */
public class BuyAspectJ {
    /**    切点：
     * execution在方法执行时触发，
     * * ：标示我们不关心方法的返回值类型
     * com.example.myannotation.entity.IBuy.buy：我们指定了全限类名和方法名
     * （..）:表示切点可以为play的任何方法，不关心传入的参数是什么
     */
    @Pointcut("execution(* com.example.myannotation.entity.IBuy.buy(..))")
    public void point(){}

    //切点的声明有两种形式：1.注解式声明 2.直接写出来
    @Before("point()")
    //这个JoinPoint也可以不写，
    public void haha(JoinPoint joinPoint){

        System.out.println("方法名字为："+joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());

        System.out.println("before");
    }

    @After("execution(* com.example.myannotation.entity.IBuy.buy(..))")
    public void lala(){
        System.out.println("after");
    }

    @AfterReturning("execution(* com.example.myannotation.entity.IBuy.buy(..))")
    public void xixi(){
        System.out.println("afterreturn");
    }

    /**
     * around是环绕通知型的，将整个目标方法封装起来，必须传入ProceedingJoinPoint这个参数和调用pj.proceed()
     * 如果没有调用会方法会处于阻塞状态
     *
     * 注意：
     * 在环绕通知里面得返回proceed，环绕通知后，被代理的方法就不返回了
     * @param pj
     */

    @Around("execution(* com.example.myannotation.entity.IBuy.buy(..))")
    public String heihei(ProceedingJoinPoint pj){
        try{
            System.out.println("around aaa.......");
            Object proceed = pj.proceed();

            System.out.println("around bbb.......");
            return (String)proceed;

        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return "...";
    }


    /**
     * 考虑参数的情况,以前我们不关心返回参数的时候，用的是*，不关心传入参数的时候，用的是..
     * 现在我们关心返回类型和输入参数
     */
    /**
     * 环绕通知，可定义目标方法的通知时间
     *     Object proceed() throws Throwable 执行目标方法
     *     Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *
     */
    @Around("execution(String com.example.myannotation.entity.IBuy.buy(double))&&args(price)")
    public String kuqi(ProceedingJoinPoint pj,double price){
        try{
            pj.proceed();
            if(price>68){
                System.out.println("超过68元了，赠送一个游戏");
                return "game";
            }
        }catch (Throwable throwable){

        }
        return "ps4";
    }
}
