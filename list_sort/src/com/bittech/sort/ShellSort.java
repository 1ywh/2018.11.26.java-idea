package com.bittech.sort;

/**
 * 希尔排序
 * 其实就是分组排序，对插入排序的补充
 * j遍历的间隔是一个间隔数>1不是1
 * Author:ywh
 * Date:2019/05/18
 */
public class ShellSort {
    public static void sort(int[] arr, int gap) {
        for (int i = 0; i < arr.length; i++) {
            //先保存它的值
            int key = arr[i];
            int j = i - gap;
            for (; j >= 0 && key < arr[j]; j = j - gap) {
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = key;
        }
    }
    public static void trueSort(int[] arr){
        int gap=arr.length;
        while(true){
            //gap=gap/2;
            gap=(gap/3)+1;
            sort(arr,gap);
            if(gap==1){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 8};
        trueSort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
