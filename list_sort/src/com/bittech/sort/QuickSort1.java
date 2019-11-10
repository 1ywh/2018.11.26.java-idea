package com.bittech.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * @author ywh
 * @date 2019/11/10 10:46
 * @description  快速排序
 */

public class QuickSort1 {
    public static void Quick(int[] arr, int left, int right) {
        //size==0/size==1
        if (left >= right) {
            return;
        }
        int index = partition3(arr, left, right);
        Quick(arr, left, index - 1);
        Quick(arr, index + 1, right);
    }

    //挖坑法
    public static int partition(int[] arr, int left, int right) {
        int pv = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= pv) {
                left++;
            }
            arr[right] = arr[left];
            while (left < right && arr[left] >= pv) {
                right--;
            }
            arr[left] = arr[right];
        }
//        arr[left] = pv;
//        return left;
        arr[right] = pv;
        return right;
    }

    //Hoare
    public static int partition1(int[] arr, int left, int right) {
        int pv = arr[left];
        int begin = left;
        int end = right;
        while (begin < end) {
            while (begin < end && arr[end] >= pv) {
                end--;
            }
            while (begin < end && arr[begin] <= pv) {
                begin++;
            }
            swap(arr, begin, end);
        }
        swap(arr, end, left);
        return end;
//        swap(arr, begin, left);
//        return begin;

    }

    public static int partition3(int[] arr, int left, int righ) {
        int i = left;
        int d = left;
        for (; arr[i] < arr[righ]; i++) {
            swap(arr, i, d);
            d++;
        }
        swap(arr, d, righ);
        return d;
    }

    private static void swap(int[] arr, int begin, int end) {
        int t;
        t = arr[begin];
        arr[begin] = arr[end];
        arr[end] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 1, 6, 5, 9, 1};
        Quick(a, 0, a.length - 1);
        for (int x : a) {
            System.out.print(String.format("%d ", x));
        }
    }
}
