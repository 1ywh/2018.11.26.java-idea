package com.ywh;

/**
 * Author:ywh
 * Date:2019/07/28
 */
public class Client {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        IUser iUser = (IUser) proxyHandler.getInstance(new User());
        iUser.add(4);
        iUser.modify("oo", 9);
    }

}
