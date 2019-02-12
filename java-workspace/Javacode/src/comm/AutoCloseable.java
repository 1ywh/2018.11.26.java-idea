package comm;

/**
 * AutoCloseable自动关闭支持
 * Author:ywh
 * Date:2019/02/11
 */
class Message implements java.lang.AutoCloseable {
    public Message() {
        System.out.println("第一条消息");
    }

    @Override
    public void close() throws Exception {
        System.out.println("自动关闭");
    }

    public void print() {
        System.out.println("www.java");
    }
}

public class AutoCloseable {

    public static void main(String[] args) {
        try (Message m = new Message()) {
            m.print();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
