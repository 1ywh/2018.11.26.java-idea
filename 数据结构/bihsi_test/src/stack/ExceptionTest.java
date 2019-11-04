package stack;


public class ExceptionTest {
    private int age;
    public static void main(String[] args) {
        //
        System.out.println(test2().age);
    }

    public static ExceptionTest test2() {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.age = 1;//1
            return exceptionTest;//final里面没有return的时候返回0
        }catch (Exception e) {
            exceptionTest.age = 2;
            return exceptionTest;
        }finally {
            exceptionTest = new ExceptionTest();
            exceptionTest.age = 3;
           // int age=3;
            return exceptionTest;//3
        }
    }

    //返回的是1
//    public static int test1() {
//        int i = 0;
//        try {
//            i = 1;
//            return i;
//        }catch (Exception e) {
//            i = 2;
//            return i;
//        }finally {
//            i = 3;
//        }
//    }
//
    //返回的是3
//    public static int test() {
//        int i = 0;
//        try {
//            i = 1;
//            return i;
//        }catch (Exception e) {
//            i = 2;
//            return i;
//        }finally {
//            i = 3;
//            return i;
//        }
//    }
}
