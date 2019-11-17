package com.bittech.sort;

/**
 * @author ywh
 * @date 2019/11/10 21:44
 * @description 堆排序，只能选最大的放在后面，不能选最小的放在前面
 * 2的h次方=n,所以h=nlogn
 * o(1)
 * 不稳定
 */
public class HeapSort {
    //向下调整成为大堆
    public static void biggest(int[] arr, int size, int index) {
        int max = 2 * index + 1;
        while (max < size) {
            if (max + 1 < size && arr[max + 1] > arr[max]) {
                max++;
            }
            if (arr[index] >= arr[max]) {
                return;
            }
            //否则就交换
            int t = arr[max];
            arr[max] = arr[index];
            arr[index] = t;

            index = max;
            max = 2 * index + 1;
        }
    }

    public static void sort(int[] arr) {
        //建大堆
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            biggest(arr, arr.length, i);
        }
        //初始大堆已经有了，然后排序，每次交换最大值和无序区间最后一个
        //堆中最后一个元素的下标
        int end = arr.length - 1;
        while (end > 0) {
            int t = arr[0];
            arr[0] = arr[end];
            arr[end] = t;
            //除了0以外都满足堆的性质，所以index=0，每次无序区间都要少一个数字
            biggest(arr, end, 0);
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,99, 5, 2,1, 7, 7,3, 6, 8, 8, 4, 9, 3, 1, 2};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
