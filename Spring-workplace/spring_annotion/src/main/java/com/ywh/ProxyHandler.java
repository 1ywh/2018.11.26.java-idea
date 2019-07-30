package com.ywh;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * 有一个补充的方法，使用PointCut来说明使用那个方法
 * 使用Advice来说明是Before、After、Throws
 * Author:ywh
 * Date:2019/07/28
 */
@Aspect
public class ProxyHandler {

    //*代表的是全部的方法
    //@Pointcut("execution(* com.ywh.User.*(..))")
   @Pointcut("execution(* com.ywh.User.add(..))")
    public void Method(){
    }
    @After("Method()")
    public void Another() {
        System.out.println("做另一个事情");
    }
}