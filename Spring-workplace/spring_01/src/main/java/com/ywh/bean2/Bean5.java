package com.ywh.bean2;

/**
 * Author:ywh
 * Date:2019/07/26
 */
public class Bean5 {
    private int age;
    private int message;
    private String name;

    public  Bean5(){

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean5{" +
                "age=" + age +
                ", message=" + message +
                ", name='" + name + '\'' +
                '}';
    }
}
