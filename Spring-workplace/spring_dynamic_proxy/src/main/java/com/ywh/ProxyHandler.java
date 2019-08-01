package com.ywh;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理是通过反射来进行的
 * Author:ywh
 * Date:2019/07/28
 */
public class ProxyHandler implements InvocationHandler {
    private Object targetObject;

    /*
    * 反射
    * */
    public Object getInstance(Object obg) {
        this.targetObject = obg;
        return Proxy.newProxyInstance(
                this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this);
    }


  public void Another(){
        System.out.println("======做另一个事情=====");
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result=null;
        Another();
        try{
            result=method.invoke(this.targetObject,objects);
        }catch(Exception e){
          e.printStackTrace();
        }
        return result;
    }
}
