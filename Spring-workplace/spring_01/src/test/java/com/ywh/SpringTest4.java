package com.ywh;

import com.ywh.bean.Student;
import com.ywh.bean2.Bean2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:ywh
 * Date:2019/07/25
 */
public class SpringTest4 {

    private Bean2 bean2 = null;

    @Before
    public void Unit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application3.xml");
        bean2 = (Bean2) context.getBean("bean2");
    }
    @Test
    public void test() {
        System.out.println("===========bean3==============");
        System.out.println(bean2.getBean3().getPassword());
        System.out.println("===========bean4==============");
        System.out.println(bean2.getBean4().getAge());
        System.out.println(bean2.getBean4().getMessage());
        System.out.println("===========bean5==============");
        System.out.println(bean2.getBean5().getAge());
        System.out.println(bean2.getBean5().getMessage());
        System.out.println(bean2.getBean5().getName());
   }

}
