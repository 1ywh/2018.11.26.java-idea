package com.ywh.core.model;


import lombok.Data;

/**
 * @author ywh
 * @date 2019/11/25 11:56
 * @description 索引之后的文件属性信息用FileThing表示
 */
public class FileThing {

    /**
     * 文件的名称，只保留名字和后缀
     */
    private String file_name;
    /**
     * 文件路径
     */
    private String file_path;
    /**
     * 文件路径深度
     */
    private Integer file_depth;

    /**
     * 文件类型
     */
    private FileType file_type;

    public String getFile_name() {
        return file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public Integer getFile_depth() {
        return file_depth;
    }

    public FileType getFile_type() {
        return file_type;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public void setFile_depth(Integer file_depth) {
        this.file_depth = file_depth;
    }

    public void setFile_type(FileType file_type) {
        this.file_type = file_type;
    }

    @Override
    public String toString() {
        return "FileThing{" +
                "file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_depth=" + file_depth +
                ", file_type=" + file_type +
                '}';
    }
}
