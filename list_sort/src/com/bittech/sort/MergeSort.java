package com.bittech.sort;

import java.util.Arrays;

/**
 * 归并排序,分治算法
 * 在左右俩个区间有序地情况下合并为一个有序数组
 * Author:ywh
 * Date:2019/05/18
 */
public class MergeSort {

    public static void merge(int[] arr, int left, int mid, int right, int[] x) {
        int k = 0;
        int i = left;// 遍历 arr [left, mid)
        int j = mid;// 遍历 arr [mid, right)
        //左右俩个区间有数
        while (i < mid && j < right) {
            //==保证稳定性
            if (arr[i] <= arr[j]) {
                x[k++] = arr[i++];
            } else {
                x[k++] = arr[j++];
            }
        }
        //i区间没走完
        while (i < mid) {
            x[k++] = arr[i++];
        }
        //j区间没走完
        while (j < right) {
            x[k++] = arr[j++];
        }
        //将数组取出来,u是原来数组的下标[left,right),x数组是[0,x.length),
        for (int u = left; u < right; u++) {
            arr[u] = x[u - left];
        }
    }

    public static void mergeInner(int[] arr, int left, int right, int[] x) {
        //size==1
        if (left == right - 1) {
            return;
        }
        //size==0
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //分治算法处理左右俩个区间
        //[left,mid)
        mergeInner(arr, left, mid, x);
        //[mid,right)
        mergeInner(arr, mid, right, x);

        //左右俩个区间有序时,将俩个有序区间合并为一个有序区间
        merge(arr, left, mid,right,x);
    }

    public static void trueSort(int[] arr) {
        int[] x = new int[arr.length];
        mergeInner(arr, 0, arr.length, x);

    }

    public static void main(String[] args) {
        int[] a = {7, 7, 6, 5, 4, 3, 0, 1};
        trueSort(a);
        System.out.println(Arrays.toString(a));

    }
}
