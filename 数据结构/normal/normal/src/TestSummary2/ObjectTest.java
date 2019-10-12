package TestSummary2;

/**
 * @author ywh
 * @date 2019/10/10 21:29
 * @description Object接收接口
 */
interface Imessage {
    void test();
}

class ImessageImpl implements Imessage {

    @Override
    public String toString() {
        return "hello java";
    }

    @Override
    public void test() {
        System.out.println("h");
    }
}

public class ObjectTest {
    private final  static int a1111 = 2;

    public static void main(String[] args) {

        // 子类向父接口转型
        Imessage imessage = new ImessageImpl();
        //向Object转型
        Object o = imessage;
        System.out.println(o);
        //强制类型转换
        Imessage imessage1 = (Imessage) o;
        imessage1.test();
        System.out.println(a1111);
    }
}
