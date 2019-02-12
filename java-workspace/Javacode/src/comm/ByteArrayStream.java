package comm;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * 内存流操作
 * Author:ywh
 * Date:2019/02/11
 */
//通过内存流实现大小写转换
public class  ByteArrayStream{
    public static void main(String[] args) throws IOException {
        String m = "mmm";
        // 实例化InputStream类对象，实例化的时候需要将你操作的数据保存到内存之中
        // 最终读取的就是你设置的内容。
        InputStream input = new ByteArrayInputStream(m.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            output.write(Character.toUpperCase(temp));
        }
        // 直接输出output对象
        System.out.println(output);
        input.close();
        output.close();
    }
}
