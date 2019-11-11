package com.bittech.heap;

import java.util.Arrays;

/**
 * @author ywh
 * @date 2019/11/10 21:36
 * @description   堆顶元素的删除、堆顶元素的查看、堆元素的添加
 *                 向下调整以及向上调整
 */
public class IHeapImpl implements IHeap {
    private int[] item;
    private int userSize;

    public IHeapImpl(int[] arr) {
        this.item =Arrays.copyOf(arr,arr.length);
        this.userSize = 0;
    }

    @Override
    public void add(int item) {
        if (Full()) {
            this.item = Arrays.copyOf(this.item, 2 * this.item.length + 1);
        }
        this.item[userSize] = item;
        this.userSize++;
        //加到最后一个了，所以要向上调整
        adjustUp(this.item, this.userSize - 1);
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            //不支持的异常
            throw new UnsupportedOperationException("堆为空");
        }
        return this.item[0];
    }

    // 返回堆顶元素，删除数据元素
    // 当然是在满足大堆的情况下
    //删除堆是删除堆顶的数据，将堆顶的数据根和最后一个数据一换，然后删除数组最后一个数据，再进行向下调
    //整算法。
    @Override
    public int pop() {

        if (isEmpty()) {
            //抛出不支持的异常
            throw new UnsupportedOperationException("堆为空");
        }
        //先保留堆顶元素
        int old=this.item[0];
        //先交换，把堆顶元素和最后一个元素交换
        int t = this.item[0];
        this.item[0] = this.item[this.userSize - 1];
        this.item[this.userSize - 1] = t;

        //完了之后将交换后的最后一个元素删除，只要userSize--，说明下次做向下调整的时候就不走这里了
        this.userSize--;
        //此时只有0位值不满足堆的性质，向下调整建大堆
        adjustDown(this.userSize , 0);
        return old;
    }


    //向下调整
    @Override
    public void adjustDown(int len, int index) {
        int max = index * 2 + 1;
        while (max < len) {
            if (max + 1 < len && this.item[max] < this.item[max + 1]) {
                max++;
            }
            if (item[index] >= item[max]) {
                break;
            }
            int t = item[index];
            item[index] = item[max];
            item[max] = t;

            index = max;
            max = index * 2 + 1;
        }
    }

    //创建大根堆
    @Override
    public void createHeap(int[] array) {

            this.userSize=array.length;

        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(this.userSize, i);
        }
    }

    //向上调整，添加元素的时候
    @Override
    public void adjustUp(int[] array, int index) {
        int parent = (index - 1) / 2;
        while (parent >= 0) {
            if (item[index] > item[parent]) {
                int t = item[index];
                item[index] = item[parent];
                item[parent] = t;
                index = parent;
                parent = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < this.userSize; i++) {
            System.out.print(item[i] + " ");
        }
    }

    @Override
    public boolean Full() {
        return this.userSize == this.item.length;
    }

    @Override
    public boolean isEmpty() {
        return this.userSize == 0;
    }
}
