package com.ywh.core.search;

import com.ywh.core.dao.NoLimitDaoImpl;
import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywh
 * @date 2019/11/25 15:11
 * @description 业务层
 */
public class FileSearchImpl implements FileSearch {

    //数据源
    //final修饰的：三种方式初始化，构造方法、立即初始化、代码块初始化
    // private final DataSource dataSource;
    // public FileSearchImpl(DataSource dataSource) {
    // this.dataSource = dataSource;
    // }

    //当有了DAO持久层时，就不需要数据源
    private final NoLimitDaoImpl LimitDao;

    public FileSearchImpl(NoLimitDaoImpl LimitDao) {
        this.LimitDao = LimitDao;
    }
    @Override
    public List<FileThing> search(FileCondition fileCondition) {
        //加个判断
        if(fileCondition==null){
            return new ArrayList<>();
        }
        return this.LimitDao.search(fileCondition);
    }
}
