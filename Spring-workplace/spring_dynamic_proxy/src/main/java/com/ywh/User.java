package com.ywh;

/**
 * Author:ywh
 * Date:2019/07/28
 */
public class User  implements IUser{
    public void add(int id) {
        System.out.println("User.add");
    }

    public void modify(String name, int id) {
        System.out.println("User.modify");
    }
}
