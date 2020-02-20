package com.ywh.core.search;

import com.ywh.core.dao.DataBaseFactory;
import com.ywh.core.dao.NoLimitDaoImpl;
import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;

import java.util.List;

/**
 * @author ywh
 * @date 2019/11/25 15:04
 * @description 检索功能
 */
public interface FileSearch {
    /**
     * 根据condition条件进行数据库的检索
     *
     * @param fileCondition
     * @return
     */
    List<FileThing> search(FileCondition fileCondition);

    //最后删掉
    public static void main(String[] args) {
        FileCondition fileCondition = new FileCondition();
        fileCondition.setName("test");
        FileSearch fileSearch = new FileSearchImpl(new NoLimitDaoImpl(DataBaseFactory.dataSource()));
        List<FileThing> list = fileSearch.search(fileCondition);
        for (FileThing f : list) {
            System.out.println(f);
        }
    }
}

