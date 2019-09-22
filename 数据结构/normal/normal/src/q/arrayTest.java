package q;

/**
 * @author ywh
 * @date 2019/9/22 21:42
 * @description 对象数组的初始化，静态和动态
 */
class B {
    private int age;
    private String major;

    public B(int a, String b) {
        this.age = a;
        this.major = b;
    }

    public void use() {
        System.out.println(this.age + " " + this.major);
    }
}

public class arrayTest {

    public static void test1() {
        //动态初始化
        B[] a = new B[3];
        a[0] = new B(1, "k");
        a[1] = new B(1, "k");
        a[2] = new B(1, "k");
        for (B b:a ) {
           b.use();
        }
    }

    public static void test2() {
        //静态初始化
        B[] a = new B[]{
                new B(1, "k"),
                new B(1, "k"),
                new B(1, "k")
        };
//        for (int i = 0; i < a.length; i++) {
//            a[i].use();
//        }
        for (B b:a ) {
            b.use();
        }
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
