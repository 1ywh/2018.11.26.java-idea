package com.ywh;

import com.ywh.bean.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserInfo里面有Student的属性，所以UserInfo依赖于Student
 * Author:ywh
 * Date:2019/07/26
 */
public class SpringTest3 {
    private UserInfo userInfo;

    @Before
    public  void  testUnit(){
        ApplicationContext context=new ClassPathXmlApplicationContext("application2.xml");
        userInfo=(UserInfo)context.getBean("userInfo");
    }
    @Test
    public void test(){
        System.out.println("student="+userInfo.getStudent().getAge()+",username="+userInfo.getStudent().getName());
    }
}
