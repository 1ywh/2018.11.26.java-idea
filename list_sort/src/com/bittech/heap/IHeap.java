package com.bittech.heap;

/**
 * @author ywh
 * @date 2019/11/10 21:35
 * @description
 */
public interface IHeap {
    // 插入 item 到堆中
    void add(int item);

    // 返回堆顶元素，不删除数据元素
    int peek();

    // 返回堆顶元素，删除数据元素
    int pop();

    void adjustDown(int len , int index);

    void createHeap(int[] array);

    void adjustUp(int[] array, int index);
    void show();
    boolean Full();
    boolean isEmpty();
}
