package TestSummary;

/**
 * @author ywh
 * @date 2019/9/25 9:32
 * @description  匿名内部类
 */
interface I {
    void test();
}
class Outer5 {
    //实现接口
    public void display() {
        new I() {
            @Override
            public void test() {
                System.out.println("匿名内部类");
            }
        }.test();
    }
}
public class NONameClass {
    public static void main(String[] args) {
        Outer5 outer5 = new Outer5();
        outer5.display();
    }
}
