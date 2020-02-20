package com.ywh.core.dao;

import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ywh
 * @date 2019/11/25 15:27
 * @description 业务层访问数据库的CRUD
 */
public interface FileDao {

    /**
     * 插入数据
     */
    void insert(FileThing fileThing) throws SQLException;

    /**
     * 根据condition条件进行数据库的检索
     */
    List<FileThing> search(FileCondition fileCondition);

}
