package com.ywh;

/**
 * @author ywh
 * @date 2019/10/30 17:13
 * @description 栈溢出
 */
public class StackTest {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        try{
            stackTest.stackLeak();
        }catch(Throwable e){
            System.out.println("Length"+stackTest.stackLength);
      throw e;
        }
    }
}
