package com;

import java.util.*;

/**
 * @author ywh
 * @date 2019/10/13 13:07
 * @description
 * 牛客：查找不重复的材料
 */
public class Main1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
          String  s = scanner.next();
           set.add(s);
        }
        System.out.println(set.size());
    }
}
