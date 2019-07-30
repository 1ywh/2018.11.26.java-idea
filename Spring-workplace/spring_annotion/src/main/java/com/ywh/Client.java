package com.ywh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Author:ywh
 * Date:2019/07/28
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        IUser iUserManager = (IUser) context.getBean("user");
        iUserManager.add(111);
        iUserManager.modify("ywh",78);

    }

}
