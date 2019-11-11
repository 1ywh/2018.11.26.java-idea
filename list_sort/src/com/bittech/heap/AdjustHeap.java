package com.bittech.heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一、向下调整：只有一个位置不满足堆，index，要调整的下标，成为大堆、称为小堆
 * 二、建堆
 * Author:ywh
 * Date:2019/04/27
 */

public class AdjustHeap {

    //向下调整，建小堆
    private static void CreateSmall(int[] arr, int index) {
        //左孩子下标
        int min = index * 2 + 1;
        //1.有叶子结点
        while (min < arr.length) {
            //2.保证有右孩子的前提下，右孩子比较小
            if (min + 1 < arr.length && arr[min + 1] < arr[min]) {
                min++;
            }
            //3.根小于该孩子结点则不执行
            if (arr[index] <= arr[min]) {
                break;
            }
            //4.否则的话交换
            int t = arr[min];
            arr[min] = arr[index];
            arr[index] = t;
            //以该结点为根，继续向下调整
            index = min;
            min = 2 * min + 1;
        }
    }

    //向下调整建大堆
    private static void CreateBig(int[] arr, int index) {
        //index就是要调整的parent
        int max = index * 2 + 1;
        /**
         * 保证有右孩子，再比较
         * 不是叶子结点，一定有左孩子，但不一定有右孩子
         * (1)没有右孩子，左边大
         * (2)有右孩子，左边大或者右边大
         * */
        //当有左孩子时执行以下
        while (max < arr.length) {
            //如果有右孩子，并且右孩子大于左孩子，改变max的值
            if (max + 1 < arr.length && arr[max + 1] > arr[max]) {
                max++;
            }
            //判断交换调整
            //当parent小于孩子时交换，否则不执行
            if (arr[index] < arr[max]) {
                int t = arr[max];
                arr[max] = arr[index];
                arr[index] = t;

                //改变index的max的值，使循环继续
                index = max;
                max = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    /*
     * 细算 O(n)
     * 粗算 O(n)*O(logn)
     */
    private static void CreateHeap(int[] arr) {
        //从最后一个非叶子结点的下标开始
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            //不断地做向下调整
            CreateSmall(arr, i);
            //CreateBig(arr,i);
        }
    }

    public static void main(String[] args) {
        int[] a = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        int[] b = {10, 7, 6, 5, 5, 7, 3, 4, 2};
        int[] b1 = {9, 5, 2, 7,3,8,6,4,9,3};
        CreateSmall(a, 0);
        CreateBig(b, 2);
        CreateHeap(b1);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : b1) {
            System.out.print(i + " ");
        }
    }
}

