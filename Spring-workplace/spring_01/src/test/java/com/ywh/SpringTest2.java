package com.ywh;

import com.ywh.bean.Bean1;
import com.ywh.bean.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:ywh
 * Date:2019/07/26
 */
public class SpringTest2 {
    private Bean1 bean1 = null;

    @Before
    public void testUnit() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application1.xml"});
        bean1 = (Bean1) context.getBean("bean1");
    }

    @Test
    public void test() {
        System.out.println("strValue=" + bean1.getStrValue());
        System.out.println("ArrayValue=" + bean1.getArrayValue());
        System.out.println("IntValue=" + bean1.getIntValue());
        System.out.println("ListValue=" + bean1.getListValue());
        System.out.println("MapValue=" + bean1.getMapValue());
        System.out.println("SetValue=" + bean1.getSetValue());

        //如果直接写这个的话会报错，因为string和达特不能互相转，有一个
        System.out.println("DateValue=" + bean1.getDateValue());
    }
}

