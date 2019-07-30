package com.ywh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 和注解方式代理的差不多。唯一有区别的就是ProxyHandler和application.xml
 * Author:ywh
 * Date:2019/07/28
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        IUser user = (IUser) context.getBean("user");
        user.add(3);
        user.modify("lll", 9);
    }

}
