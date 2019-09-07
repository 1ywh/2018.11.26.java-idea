package test;

import java.util.*;

/**
 * @author ywh
 * @date 2019/9/7 11:30
 * @description 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 */
public class Solution {

    public static List<String> commonChars(String[] A) {
        List<String> r = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = null;
        int i = 0;
        for (; i < A.length; i++) {
            map1 = new HashMap<>();
            //先把第一个放进去，当作例子
            if (i == 0) {
                //算出每个字符存在的数目
                for (int j = 0; j < A[i].length(); j++) {
                    int m = map.getOrDefault(A[i].charAt(j), 0);
                    map.put(A[i].charAt(j), m + 1);
                }
                //r中首先存放第一个字符串
                for (Map.Entry<Character, Integer> a : map.entrySet()) {
                    char b = a.getKey();
                    int c = a.getValue();
                    for (int p = 0; p < c; p++) {
                        r.add(String.valueOf(b));
                    }
                }
                continue;
            }
            //从第二个字符串开始
            //算出该字符串的个数
            for (int j = 0; j < A[i].length(); j++) {
                int m = map1.getOrDefault(A[i].charAt(j), 0);
                map1.put(A[i].charAt(j), m + 1);
            }
            for (Map.Entry<Character, Integer> a : map1.entrySet()) {
                int num=0;
                char b = a.getKey();
                int c = a.getValue();
                //应该每次和list里面的字符个数比较
                for(int o=0;o<r.size();o++){
                    if(r.get(o).equals(String.valueOf(b))){
                        num++;
                    }
                }
                int d = num - c;
                if (num != 0) {
                    //说明第一个字符串里面有这个值，但是多了几个，删掉
                    if (d > 0) {
                        for (int p = 0; p < d; p++) {
                            r.remove(String.valueOf(b));
                        }
                    }
                }
            }
            for (Map.Entry<Character, Integer> a : map.entrySet()) {
                char b = a.getKey();
                int c = a.getValue();
                //如果其他的里面没有第一个字符串中的那么删掉
                if (!map1.containsKey(b)) {
                    for(int t=0;t<c;t++){
                        r.remove(String.valueOf(b));
                    }
                }
            }
        }
        return r;
    }


    public static void main(String[] args) {
        String[] b = {"bella", "label", "roller"};
        String[] s = {"bbddabab","cbcddbdd","bbcadcab","dabcacad","cddcacbc","ccbdbcba","cbddaccc","accdcdbb"};
        System.out.println(commonChars(s));
    }
}