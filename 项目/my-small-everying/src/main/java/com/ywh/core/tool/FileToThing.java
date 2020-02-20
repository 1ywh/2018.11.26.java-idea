package com.ywh.core.tool;

import com.ywh.core.model.FileThing;
import com.ywh.core.model.FileType;

import java.io.File;

/**
 * 辅助工具类：把File对象转换成FileThing对象
 *
 * @author ywh
 * @date 2019/11/25 19:10
 * @description
 */
public class FileToThing {

    public static FileThing transfer(File file) {
        FileThing fileThing = new FileThing();
        fileThing.setFile_name(file.getName());
        fileThing.setFile_path(file.getAbsolutePath());
        fileThing.setFile_depth(getFileDepth(file));
        fileThing.setFile_type(getFileType(file));

        return fileThing;
    }

    //得到文件深度
    public static int getFileDepth(File file) {
//        String[] extra = file.getAbsolutePath().split(File.separator);
        String[] extra = file.getAbsolutePath().split("\\\\");
        return extra.length;
    }

    //找文件类型,以"."来分割
    public static FileType getFileType(File file) {
        //如果是目录，就返回全部*
        if (file.isDirectory()) {
            return FileType.OTHER;
        }
        String fileName = file.getName();
        //找到最后一个"."的下标
        int index = fileName.lastIndexOf(".");
        if (index != -1 && index < file.length() - 1) {
            //获得后缀名，也就是类型
            String result = fileName.substring(index + 1);
            return FileType.lookup(result);
        } else {
            return FileType.OTHER;
        }
    }
}
