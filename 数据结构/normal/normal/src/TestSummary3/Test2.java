package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/20 10:25
 * @description
 */

public class Test2 {
    static class Person{
        {
            System.out.println("1.Person类的构造块");
        }
        public Person(){
            System.out.println("2.Person类的构造方法");
        }
        static {
            //定义在非主类的静态块
            System.out.println("3.Person类的静态块");
        }
    }
    public static void main(String[] args) {
        System.out.println("--start--");
        new Person();
        new Person();
        System.out.println("--end--");
    }
}
