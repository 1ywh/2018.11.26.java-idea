package TestSummary2;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/10/9 19:03
 * @description 模板设计模式
 * 有一个抽象类含有公共的方法，所有类使用，子类实现抽先类，可以覆写钩子方法
 * 来判断要不要实现某个方法
 */
abstract class IC {
    //由主类调用这个方法，final子类不能覆写这个方法
    final void prepareTest() {
        publicMethod1();
        if (hook()) {
            publicMethod2();
        }
        step1();
        step2();
    }

    //公共的方法
    public void publicMethod1() {
        System.out.println("倒水");
    }

    public void publicMethod2() {
        System.out.println("加辅料");
    }

    //抽象类，由子类实现
    abstract void step1();

    abstract void step2();

    //也可以加一个钩子方法：就是默认不做事的方法，由子类来决定要不要覆写
    boolean hook() {
        return true;
    }

}

class A extends IC {

    @Override
    void step1() {
        System.out.println("A3");
    }

    @Override
    void step2() {
        System.out.println("A4");
    }
}

class B extends IC {

    @Override
    void step1() {
        System.out.println("B3");
    }

    @Override
    void step2() {
        System.out.println("B4");
    }

    public boolean hook() {
       String answer= answer();
        if(answer.equals(true)){
            return true;
        }else{
            return false;
        }
    }

    public String answer() {
        System.out.println("Do you want to add something(true/false) ?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

public class PatterClass {
    public static void main(String[] args) {

//        IC a = new A();
//        a.prepareTest();
        IC b = new B();
        b.prepareTest();
    }


}
