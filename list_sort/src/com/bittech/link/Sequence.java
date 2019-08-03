package com.bittech.link;

/**
 * 顺序表
 * Author:ywh
 * Date:2019/03/31
 */
public class Sequence implements IArrayList {
    private int[] arr;
    private int size;

    public static void main(String[] args) {

    }

    //1.头插O(n)
    @Override
    public void pushFront(int item) {
        //空间
        for (int i = this.size; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        //数据
        for (int i = this.size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        this.arr[0] = item;
        this.size++;
    }

    //2.尾插,O(1)直接插入
    @Override
    public void pushBack(int item) {
        arr[this.size] = item;
        this.size++;
    }

    //3.在index处插入,O(n)
    @Override
    public void add(int item, int index) {
        //异常判断
        if (index < 0 || index > size) {
            throw new Error();
        }
        //1.空间
        for (int i = this.size; i >= index + 1; i--) {
            arr[i] = arr[i - 1];
        }
        //2.数据
        for (int i = this.size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        //3.
        for (int i = 0; i < this.size - index; i++) {
            arr[this.size - i] = arr[this.size - 1 - i];

        }
        this.arr[index] = item;
        this.size++;
    }

    //4.头删,O(n)
    @Override
    public void popFront() {
        if (this.size == 0) {
            throw new Error();
        }
//        for(int i=this.size;i>=2;i--){
//            arr[i-2]=arr[i-1];
//        }
//        for(int i=this.size-1;i>0;i--){
//            arr[i-1]=arr[i];
//        }
        for (int i = 0; i < this.size - 1; i++) {
            arr[i] = arr[i + 1];

        }
        for (int i = 1; i < this.size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--this.size] = 0;
    }

    //5.尾删,O(1)
    @Override
    public void popBack() {
        if (this.size == 0) {
            throw new Error();
        }
        arr[--this.size] = 0;
        this.size--;

    }

    //6.index处删除,O(n)
    @Override
    public void remove(int item, int index) {
        if (index < 0 || index > this.size || this.size == 0) {
            throw new Error();
        }
        for (int i = index; i < this.size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        for (int i = index + 1; i < this.size; i++) {
            arr[i - 1] = arr[i];
        }
        this.arr[--this.size] = 0;
    }
    //7.扩容

    public void ensureCapacity() {
        if (this.arr.length > this.size) {
            return ;
        }
        //找到一个新的房子
        int[] a=new int[this.arr.length*2];
        //搬家
        for(int i=0;i<this.size;i++){
            a[i]=arr[i];
        }
        //退掉老房子
        arr=a;
    }

}
