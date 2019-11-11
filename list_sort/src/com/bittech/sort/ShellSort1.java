package com.bittech.sort;

/**
 * @author ywh
 * @date 2019/11/11 12:37
 * @description  希尔排序，其实和那个插入排序一样，是它的优化
 */
public class ShellSort1 {
    public static void sort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int p = arr[i];
            int j = i - gap;
            for (; j >= 0 && arr[j] < p; j = j - gap) {
                arr[j + gap] = arr[j];
            }
            arr[j +gap] = p;
        }
    }

    public static void sort1(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            sort(arr, gap);
            gap = (gap / 3) + 1;
        }
        //全排
        sort(arr, 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2};
        sort1(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
