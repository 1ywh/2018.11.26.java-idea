package lambda;

/**(参数)->{多行语句；语句；}
 * Author:ywh
 * Date:2019/02/10
 */
@FunctionalInterface
interface N {
    void print();
}
public class Lambda2 {
    public static void main(String[] args) {
        N n = () -> {
            //注意分号
            System.out.println("hello");
            System.out.println("java");
        };
        n.print();
    }
}

