package TestSummary;

/**
 * @author ywh
 * @date 2019/9/25 8:45
 * @description 方法内部类
 */
class Outer2 {
    private int name;

    public void fun() {
        class B {
            public void print() {
                name++;
                System.out.println(name);

            }
        }
        new B().print();
    }
}

public class MethodClass {
    public static void main(String[] args) {
        Outer2 outer2=new Outer2();
        outer2.fun();
    }
}


