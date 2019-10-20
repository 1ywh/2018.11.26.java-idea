package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/20 10:53
 * @description 静态域的执行顺序
 */

public class Test4 {
    public static Test4 main1 = new Test4();
    static {
        System.out.println("静态块");
    }

    public static Test4 main2 = new Test4();

    {
        System.out.println("构造块");
    }

    public Test4() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Test4 main3 = new Test4();
    }
}
