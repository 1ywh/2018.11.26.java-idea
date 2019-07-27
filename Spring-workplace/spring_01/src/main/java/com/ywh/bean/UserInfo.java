package com.ywh.bean;

import com.ywh.bean.Student;

/**
 * Author:ywh
 * Date:2019/07/25
 */
public class UserInfo {
    private  String username;
    private Student student;


    public UserInfo(){

    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
