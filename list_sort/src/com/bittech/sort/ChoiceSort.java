package com.bittech.sort;

/**
 * 选择排序、冒泡排序
 * Author:ywh
 * Date:2019/04/27
 */
public class ChoiceSort {

    //选择排序
    public static void selectSort(int[] arr) {
        //每次找出最小的数下标
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            //从i这个位置开始遍历寻找
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
    }

    //冒泡排序
    //由小到大
    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
            int t;
                if (arr[j + 1] < arr[j]) {
                    t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4};
        //selectSort(a);
        bubbleSort1(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}

