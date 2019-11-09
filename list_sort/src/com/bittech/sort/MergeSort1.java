package com.bittech.sort;

import java.util.Arrays;

/**
 * @author ywh
 * @date 2019/11/9 20:43
 * @description 归并排序 ，分治算法思想，[0,mid] 和 [mid+1,arr.length-1]
 * */
public class MergeSort1 {
    private static void Sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        Sort(arr, left, mid);
        Sort(arr, mid + 1, right);
        merDivSort(arr, left, right, mid);
    }

    private static void merDivSort(int[] arr, int left, int right, int mid) {
        int[] extra = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        //如果没有越界，俩个一直往下走
        while (p1 <= mid && p2 <= right) {
            extra[i++] = arr[p1] < arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            extra[i++] = arr[p1++];
        }
        while (p2 <= right) {
            extra[i++] = arr[p2++];
        }
        //转移数组
        for (i = 0; i < extra.length; i++) {
            arr[left + i] = extra[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 52, 5, 1};
        Sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
