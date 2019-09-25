package TestSummary;

/**
 * @author ywh
 * @date 2019/9/25 15:16
 * @description  继承的应用,实例的时候先执行父类的构造方法
 */
class Parent {
    private String name;

    public Parent(){
        System.out.println("o");
    }

    public void test(){
        System.out.println(1);
    }
    public void test1(){
        System.out.println(1);
    }
}
class Student extends Parent{
    public void test(){
        System.out.println(2);
    }
    public Student(){

        System.out.println(4);
    }
}
public class ExtendsClass {
    public static void main(String[] args) {
        new Student().test();
        System.out.println("=======");
        //在这里构造方法优先于普通方法

    }
}
