package stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ywh
 * @date 2019/10/16 17:34
 * @description  文件的操作
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\b.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try( OutputStream outputStream = new FileOutputStream(file)){

            outputStream.write("kk".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
