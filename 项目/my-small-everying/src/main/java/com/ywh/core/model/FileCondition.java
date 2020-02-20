package com.ywh.core.model;


/**
 * @author ywh
 * @date 2019/11/25 12:03
 * @description 检索的一些限制
 */

/**
 * 检索结果的文件信息 按照depth排序
 * 1.默认是true--asc
 * 2.false --desc
 */

public class FileCondition {
    private String name;
    private String fileType;
    private Integer limit;
    private boolean orderBy;

    public void setName(String name) {
        this.name = name;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public boolean getOrderBy() {
        return orderBy;
    }

    @Override
    public String toString() {
        return "FileCondition{" +
                "name='" + name + '\'' +
                ", fileType='" + fileType + '\'' +
                ", limit=" + limit +
                ", orderBy=" + orderBy +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFileType() {
        return fileType;
    }

    public Integer getLimit() {
        return limit;
    }
}