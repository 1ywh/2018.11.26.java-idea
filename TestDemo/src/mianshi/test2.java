package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ywh
 * @date 2020/3/23 22:35
 * @description  
 */
public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        int count = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    list1.add(s1.charAt(i));
                    list2.add(s2.charAt(i));
                }
            }
            int len = list1.size();
            for (int i = 0; i < len; i++) {
                //不等于的时候开始
                if (list1.get(i) != list2.get(i)) {
                    //包含的话，找到交换
                    if (list1.contains(list2.get(i))) {
                        for (int j = i + 1; j < len; j++) {
                            if (list1.get(j) == list2.get(i)) {
                                char v = list1.get(i);
                                list1.set(j, v);
                                count++;
                                break;
                            }
                        }
                    } else {
                        list1.set(i, list2.get(i));
                        count++;
                    }
                }
                list1.set(i, '0');
                list2.set(i, '0');
            }
        }
        System.out.println(count);
    }
}
