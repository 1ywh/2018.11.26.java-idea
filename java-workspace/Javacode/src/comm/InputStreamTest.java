package comm;

import java.io.*;

/**
 * InputStream
 * Author:ywh
 * Date:2019/02/11
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File(File.separator + "F:" + File.separator + "Java"
                + File.separator + "Test1" + File.separator + "HH.txt");
        // 2.必须保证文件存在才能进行处理
        if (file.exists()) {
            InputStream input = new FileInputStream(file);
            byte[] data = new byte[1024]; // 每次可以读取的最大数量
            int len = input.read(data); // 此时的数据读取到了数组之中
            String result = new String(data, 0, len); // 将字节数组转为String
            System.out.println("读取内容【" + result + "】");
            input.close();

        }
    }
}
