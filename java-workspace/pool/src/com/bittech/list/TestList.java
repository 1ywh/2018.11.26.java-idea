package com.bittech.list;

import java.util.*;

/**List½Ó¿Ú
 * ArrayList,Vector
 * Author:ywh
 * Date:2019/03/14
 */
public class TestList {

    public static void main(String[] args) {
//        Collection<String> l = new ArrayList<>();
//        l.add("i");
//        l.add("o");
//        Object[] c = l.toArray();
//        System.out.println(Arrays.toString(c));
       List<String> l=new ArrayList<>();
        l.add("l");
        l.add("o");
        System.out.println(l);
        l.remove("o");
        System.out.println(l);
        System.out.println(l.size()+"\n"+l.contains("l"));

    }
}
