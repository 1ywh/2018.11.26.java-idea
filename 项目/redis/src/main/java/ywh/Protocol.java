package ywh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:ywh
 * Date:2019/11/14
 * 做协议处理,字节流转换为对象
 */
public class Protocol {

    public static Command readCommand(InputStream in) throws Exception {
        Object o = read(in);
        //Server不会收到“+OK\r\n,必须是list”
        if (!(o instanceof List)) {
            throw new RemoteException("对方发送的命令不是 array 形式");
        }
        //转型
        List<Object> list = (List<Object>) o;
        if (list.size() < 1) {
            throw new RemoteException("命令元素个数大于1");
        }
        //命令名称取出来删掉
        Object o1 = list.remove(0);
        if (!(o1 instanceof byte[])) {
            throw new RemoteException("对方发送的命令不是 list 形式");
        }
        //转型
        byte[] array = (byte[]) o1;
        String commandName = new String(array);
        //通过对象得到类的名字
        String className = String.format("command.%sCommand", commandName);
        Class<?> cls = Class.forName(className);
        //Command的类是不是子类和实现类，
        if (!(Command.class.isAssignableFrom(cls))) {
            throw new RemoteException("错误的命令");
        }
        //转为实例
        Command command = (Command) cls.newInstance();
        command.setArgs(list);
        return command;
    }

    //1.+oo\r\n
    private static String processSimpleString(InputStream is) throws Exception {
        return readLine(is);
    }

    //2.\-Err\r\n读Error和readLine一样，读取的string
    private static String processError(InputStream is) throws Exception {
        return readLine(is);
    }

    //3.-1\r\n
    private static long processInteger(InputStream is) throws Exception {
        return readInteger(is);
    }


    //4.读取byte---->bulkString
    public static byte[] readBytes(InputStream is) throws Exception {
        //读取长度
        int len = (int) readInteger(is);
        if (len == -1) {
            return null;
        }
//        byte[] bytes = new byte[len];
//        for (int i = 0; i < len; i++) {
//            bytes[i] = (byte) is.read();
//        }
        byte[] bytes = new byte[len];
        is.read(bytes, 0, len);

        is.read();
        is.read();
        return bytes;

    }

    //5.读取List----->数组
    private static List<Object> processArray(InputStream is) throws Exception {
        //读取长度
        int len = (int) readInteger(is);
        if (len == -1) {
//            *-1\r\n  ===>null
            return null;
        }
        List<Object> obj = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            try {
                obj.add(read(is));
            } catch (RemoteException e) {
                obj.add(e);
            }
        }
        return obj;
    }

    //1.java---String类型，redis------simpleString,一直读直到\r\n,如果中间有那个转义的话，会识别
    public static String readLine(InputStream in) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        //类似状态转换机
        boolean need = true;
        int b = 0;
        while (true) {
            if (need == true) {
                b = in.read();
                if (b == -1) {
                    throw new Exception("不能读到下一个");
                }
            } else {
                need = true;
            }
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new Exception("不能读到下一个");
                }
                //已经读完了
                if (c == '\n') {
                    break;
                }
                if (c == '\r') {
                    //保持这个状态不动从头开始继续读
                    stringBuilder.append(b);
                    b = c;
                    need = false;
                } else {
                    stringBuilder.append((char) b);
                    stringBuilder.append((char) c);
                }
            } else {
                //当前不是\r读取
                stringBuilder.append((char) b);
            }
        }
        return stringBuilder.toString();
    }

    //2.java---long类型，redis-----Integer
    //如果是负数的话需要转为整数，所以需要一个boolean的变量
    public static long readInteger(InputStream in) throws Exception {
        boolean isInteger = false;
        StringBuilder stringBuilder = new StringBuilder();
        int b = in.read();
        if (b == -1) {
            throw new RuntimeException("不能读到最后一个");
        }
        //此处保留负数的情况
        if (b == '-') {
            isInteger = true;
        } else {
            stringBuilder.append((char) b);
        }
        while (true) {
            b = in.read();
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new Exception("error");
                }
                if (c == '\n') {
                    break;
                }
                throw new Exception("，我们只读现在还没有读到\r\n");
            } else {
                stringBuilder.append((char) b);
            }
        }
        //只解析long型的数字
        long number = Long.parseLong(stringBuilder.toString());

        if (isInteger) {
            return -number;
        } else {
            return number;
        }
    }

    public static Object read(InputStream is) throws Exception {
        int a = is.read();
        if (a == -1) {
            throw new Exception("不能读到结尾");
        }
        switch (a) {
            case '+':
                return processSimpleString(is);
            case ':':
                return processInteger(is);
            case '-':
                throw new RemoteException(processError(is));
            case '$':
                return readBytes(is);
            case '*':
                return processArray(is);
            default:
                throw new RuntimeException("不识别的类型");
        }
    }

    public static void writeError(OutputStream out, String s) throws IOException {
        out.write('-');
        out.write(s.getBytes());
        out.write("\r\n".getBytes());
    }

    public static void writeInteger(OutputStream out, long size) throws IOException {
        out.write(':');
        out.write(String.valueOf(size).getBytes());
        out.write("\r\n".getBytes());
    }

    public static void writeArray(OutputStream out, List<String> list) throws Exception {
        out.write('*');
        out.write(String.valueOf(list.size()).getBytes());
        out.write("\r\n".getBytes());//长度
        for (Object o : list) {
            if (o instanceof String) {
                writeBulkString(out, (String) o);
            } else if (o instanceof Long) {
                writeInteger(out, (Long) o);
            } else if (o instanceof Integer) {
                writeInteger(out, (Integer) o);
            } else {
                throw new Exception("错误的类型");
            }

        }

    }

    public static void writeBulkString(OutputStream out, String o) throws IOException {
        byte[] buf = o.getBytes();
        out.write('$');
        //长度
        out.write(String.valueOf(buf.length).getBytes());
        out.write("\r\n".getBytes());
        out.write(buf);
        out.write("\r\n".getBytes());
    }

    public static void writeNull(OutputStream out) throws IOException {
        out.write('&');
        out.write('-');
        out.write('1');
    }
}