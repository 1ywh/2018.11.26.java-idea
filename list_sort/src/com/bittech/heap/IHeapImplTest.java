package com.bittech.heap;

/**
 * @author ywh
 * @date 2019/11/11 8:11
 * @description  插入、删除测试
 */
public class IHeapImplTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        IHeapImpl iHeap = new IHeapImpl(a);
        iHeap.createHeap(a);
        iHeap.show();
        System.out.println();
        iHeap.add(11);
        iHeap.show();
        System.out.println();
        int top=iHeap.pop();
        System.out.println(top);
        iHeap.show();
    }
}
