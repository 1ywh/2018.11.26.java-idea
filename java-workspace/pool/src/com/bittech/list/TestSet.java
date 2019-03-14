package com.bittech.list;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**TreeSetºÍHashSet
 * Author:ywh
 * Date:2019/03/14
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> l=new TreeSet<>();
        l.add("p");
        l.add("o");
        System.out.println(l);
        Set<String> lo=new HashSet<>();
        lo.add("p");
        lo.add("o");
        System.out.println(lo);

    }
}
