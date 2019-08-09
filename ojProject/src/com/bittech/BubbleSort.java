package com.bittech;

import java.util.Comparator;


/**
 * 冒泡排序
 * Author:ywh
 * Date:2019/07/23
 */

public class BubbleSort {

    public static void main(String[] args) {
        sort(new Integer[]{1, 2, 3, 4});
    }

    public static <T> void sort(T[] t) {
        boolean swap = true;
        Comparator<T> comparator = null;
        for (int i = 0; i < t.length && swap; ++i) {
            swap = false;
            for (int j = 0; i < t.length - i; ++j) {
                if (comparator.compare(t[j], t[j + 1]) > 0) {
                    T tmp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = tmp;
                    swap = true;
                }
            }
        }
        for (T s : t) {
            System.out.print(s + " ");
        }
    }
}



