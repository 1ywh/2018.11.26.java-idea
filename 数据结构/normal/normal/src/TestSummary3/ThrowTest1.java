package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/11 22:05
 * @description  final,对象调用属性
 */
class Final {
    public final String color = "bule";
    public String size = "i";

    public Final() {
    }

    public Final(String size) {
        this.size = size;
    }
}
//
//class UserError extends Exception {
//    public UserError(String message) {
//        super(message);
//    }
//}
//
//class PasswordError extends Exception {
//    public PasswordError(String message) {
//        super(message);
//    }
//}

public class ThrowTest1 {
    private static String userName = "a";
    private static String password = "123456";

    public static void main(String[] args) {
        //  Final f=new Final();
        Final f1 = new Final("27");
        String s = f1.size;
        System.out.println(s);
    }
}