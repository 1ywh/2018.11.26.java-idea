package com.ywh.bean2;

/**
 * Author:ywh
 * Date:2019/07/26
 */
public class Bean2 {
     Bean3 bean3=new Bean3();
     Bean4 bean4=new Bean4();
     Bean5 bean5=new Bean5();

     public Bean2(){

     }
    public Bean3 getBean3() {
        return bean3;
    }

    public void setBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }

    public Bean4 getBean4() {
        return bean4;
    }

    public void setBean4(Bean4 bean4) {
        this.bean4 = bean4;
    }

    public Bean5 getBean5() {
        return bean5;
    }

    public void setBean5(Bean5 bean5) {
        this.bean5 = bean5;
    }
}
