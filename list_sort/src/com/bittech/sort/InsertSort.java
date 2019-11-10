package com.bittech.sort;


/**
 * 重要：插入排序:每次从无序区间中找数，在有序区间遍历
 * 直接插入
 * Author:ywh
 * Date:2019/05/18
 */
public class InsertSort {
    //1.直接插入
    //1.1方法一：边找边搬
    public static void insertSort1(int[] arr) {
//        外循环需要让每个数都保持有序所以是length
//        内循环遍历查找，从后往前找，只有在有序中找到大于它的然后往后移动
//        最后将保存的数字插到对应位置
        for (int i = 0; i < arr.length; i++) {
            //把该数保留下来方便后续插入
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && key < arr[j]; j--) {
                //边找边往后搬
                arr[j + 1] = arr[j];
            }
            //j+1就是要插入的下标
            arr[j + 1] = key;
        }
    }

    //1.2方法2：先找再搬
    public static void insertSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //找下标,j+1
            int j = i - 1;
            //j>=0
            for (; j >= 0 && arr[i] < arr[j]; j--) {

            }
            //保存最后一个数
            int key = arr[i];
            //从前往后搬
            for (int k = i - 1; k > j; k--) {
                arr[k + 1] = arr[k];
            }
            arr[j + 1] = key;
        }
    }

    //1.3方法3：二分查找，搬
    public static void insertSort3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //先保存
            int key = arr[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (key == arr[mid]) {
                    left = mid + 1;
                } else if (key < arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //pos就是要插入的下标，是>pos-1
            int pos = left-1;
            for (int k = i - 1; k > pos; k--) {
                arr[k + 1] = arr[k];
            }
            arr[pos+1] = key;
        }

    }

    public static void main(String[] args) {
        int[] a = {6, 4, 5, 3, 7, 8};
        int[] b = {6,2,5,1, 7, 8};
        int[] c = {6, 4,9,5,3, 7, 8};
        insertSort1(a);
        insertSort2(b);
        insertSort3(c);
        for (int i : a) {
            System.out.print(" "+i);
        }
        System.out.println();
        for (int j : b) {
            System.out.print(" "+j);
        }
        System.out.println();
        for (int i : c) {
            System.out.print(" "+i);
        }
    }
}
