package com.ywh;

import com.ywh.bean.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 最简单的DI
 * Author:ywh
 * Date:2019/07/25
 */
public class SpringTest1 {
    private Student student = null;


    @Before
    public void testInit() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
       student= (Student)context.getBean("test1");
    }

    @Test
    public void test() {
        student.test1();
        System.out.println("name=" + student.getName() + ",age" + student.getAge());
    }
}
