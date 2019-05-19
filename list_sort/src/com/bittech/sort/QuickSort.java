package com.bittech.sort;

/**
 * 快速排序处于交换排序
 * 1.找到基准值，三个方法
 * 2.开始partition遍历区间将小于基准值放在左边，大的放在右边，三个方法
 * 3.分治算法，利用递归分成三个小区间
 * Author:ywh
 * Date:2019/04/27
 */
public class QuickSort {
    //一、找基准值
    //1.选择最边上的数，左右都行，选左边从右边先走，选右边从左边先走
    //int pivot=arr[right]或者是int pivot=arr[left]
    //2.随机数法
    //3.三数取中法
    //对于2和3，选好基准之后交换到最边上

    //三数取中法
    public static int sanShuQuZhong(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[right]) {
            if (arr[right] > arr[mid]) {
                return right;
            } else if (arr[left] > arr[mid]) {
                return mid;
            } else {
                return left;
            }
        } else {
            if (arr[right] < arr[mid]) {
                return right;
            } else if (arr[left] < arr[mid]) {
                return mid;
            } else {
                return left;
            }

        }
    }

    //二、开始遍历通过partition遍历区间将小于等于基准值放在左边，大于等于放在右边
    //1.hover法，左右遍历
    public static int partition1(int[] arr, int left, int right) {
        int begin = left;
        int end = right;
        //先将基准值选在数组最后一个元素
        int pivot = arr[right];
        while (begin < end) {
            //一个下标从左开始，保证begin左边的<=基准值
            //当arr[begin]>arr[pivot]时结束
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }

            //一个下标从右开始，保证end右边的>=基准值
            //当arr[end]<arr[pivot]时结束
            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            //遇到不符合的时候交换俩个值继续,就是俩个while都结束
            swap(arr, begin, end);
        }
        //直到begin==end将基准值交换到中间
        swap(arr, begin, right);
        //begin就是基准值
        return begin;
    }

    //2.挖坑法，左右遍历
    public static int partition2(int[] arr, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = arr[right];
        while (begin < end) {
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            arr[end] = arr[begin];
            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            arr[begin] = arr[end];
        }
        //begin==end的时候将pivot放回去则把区间分成三部分
        arr[begin] = pivot;
        return begin;
    }
    //3.前后下标法，单向遍历
    public static int partition3 (int[] arr,int left,int right){
        int i=left;
        int d=left;
        //不包含arr[right],因为是和arr[right]进行的比较
        for(;i<right;i++){
            //只有小于的时候才走
           if (arr[i]<arr[right]){
                swap(arr,i,d);
                d++;
            }
        }
        swap(arr,d,right);
        return d;
    }

    private static void swap(int[] arr, int begin, int end) {
        int t;
        t = arr[begin];
        arr[begin] = arr[end];
        arr[end] = t;
    }

    //三、分治算法
    //分别对左右俩个小区间做同样的处理
    //直到小区间的size==0||size==1(有序)
    public static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //1.找基准值,把基准值交换到边上
        int standardNum=sanShuQuZhong(arr,left,right);
        swap(arr,standardNum,right);

        //2.通过partition区间分为三个部分
        int pivotIndex = partition1(arr, left, right);

        //3.分治算法
        //3.1处理比基准值小的区间
        quick(arr, left, pivotIndex - 1);

        //3.2处理比基准值大的区间
        quick(arr, pivotIndex + 1, right);
    }


    public static void main(String[] args) {
        int[] a = {9, 3, 5, 4, 4, 3,2,1};
        quick(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
