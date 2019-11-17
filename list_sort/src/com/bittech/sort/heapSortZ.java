package com.bittech.sort;

/**
 * @author ywh
 * @date 2019/11/15 19:11
 * @description   堆排序
 */
public class heapSortZ {
    //插入的同时建立大堆
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int p = arr[index];
        arr[index] = arr[i];
        arr[i] = p;
    }
    public static void heapSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        //先建立大堆 ，O（n）
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            heapify(arr, 0, end);
            end--;
        }
    }

    //O（logn）
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? largest : index;
            if (largest == index) {
                return;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 5, 2, 7, 3, 6, 8, 8, 4, 9, 3, 1, 2};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
