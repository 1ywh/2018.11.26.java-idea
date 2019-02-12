package comm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * AutoCloseable使用自动关闭处理之前的操作
 * Author:ywh
 * Date:2019/02/11
 */
public class AutoCloseable1 {
    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Java" + File.separator + "Test1" + File.separator + "DD.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (OutputStream out = new FileOutputStream(file)) {
            String a = "java";
            out.write(a.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
