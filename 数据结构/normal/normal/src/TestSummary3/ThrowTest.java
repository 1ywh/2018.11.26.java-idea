package TestSummary3;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/10/11 20:26
 * @description 自定义异常类
 */
class AddException extends Exception {
    public AddException(String message) {
        super(message);
    }
}

class SubException extends Exception {
    public SubException(String message) {
        super(message);
    }
}

public class ThrowTest {
    private static String userName = "ywh";
    private static String password = "123456";

    public static void test(String userName, String password) throws AddException, SubException {
        if (!ThrowTest.userName.equals(userName)) {
            throw new AddException("用户名错误");
        }
        if (!ThrowTest.password.equals(password)) {
            throw new SubException("密码错误");
        }
        System.out.println("登陆成功");
    }

    public static void main(String[] args) throws Exception {
//        try {
//            test("ywh", "123456");
//        }catch (AddException a){
//            a.printStackTrace();
//        }catch (SubException s){
//            s.printStackTrace();
//        }
        test("ywh", "12345");}
}
