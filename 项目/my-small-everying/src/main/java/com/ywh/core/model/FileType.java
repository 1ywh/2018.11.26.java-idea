package com.ywh.core.model;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件类型
 *
 * @author ywh
 * @date 2019/11/25 10:33
 * @description
 */

public enum FileType {
    //文件类型
    ING("img", "jpeg", "jpe", "gif"),//图片
    DOC("ppt", "doc", "txt", "pdf"),//文档
    BIN("exe", "sh", "jar", "msi"),//二进制
    ARCHIVE("jar", "zip"),//规则
    OTHER("*");//其他类型
    //全部加入Set
    /**
     * 对应的文件类型的拓展名集合
     */
    private Set<String> file = new HashSet<>();
    private FileType(String... file) {
        this.file.addAll(Arrays.asList(file));
    }
    /**
     * 根据文件拓展名获取文件类型
     */
    public static FileType lookup(String file) {
        for (FileType files : FileType.values()) {
            if (files.file.contains(file)) {
                return files;
            }
        }
        return FileType.OTHER;
    }
    /**
     * 根据文件类型名获取文件类型对象
     */
    public static FileType lookupByName(String name) {
        for (FileType files : FileType.values()) {
            if (files.name().equals(name)) {
                return files;
            }
        }
        return  FileType.OTHER;
    }
}
