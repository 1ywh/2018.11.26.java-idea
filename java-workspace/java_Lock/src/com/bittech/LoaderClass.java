package com.bittech;

/**自定义类加载器
 * Author:ywh
 * Date:2019/03/05
 */

class Member{
    @Override
    public String toString() {
        return "Member";
    }
}
public class LoaderClass {
    public static void main(String[] args) throws Exception{
        System.out.println(Class.forName("com.bittech.Member").getClassLoader().loadClass("Member").newInstance());
    }
}