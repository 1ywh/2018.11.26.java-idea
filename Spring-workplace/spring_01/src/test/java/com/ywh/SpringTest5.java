package com.ywh;

import com.ywh.bean2.Bean2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:ywh
 * Date:2019/07/25
 */
public class SpringTest5 {


    private Bean2 bean2 = null;
    private Bean2 bean2_1 = null;
    ApplicationContext context;

    @Before
    public void Unit() {
        context = new ClassPathXmlApplicationContext("application4.xml");

    }

    @Test
    public void test2() {
        bean2 = (Bean2) context.getBean("bean2");
        bean2_1 = (Bean2) context.getBean("bean2");
        if(bean2_1==bean2){
            System.out.println("bean2 is singleton");
        }else{
            System.out.println("bean2 is multible");
        }
    }
}
