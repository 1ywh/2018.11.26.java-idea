package com.ywh.core.interceptor;

import com.ywh.core.dao.FileDao;
import com.ywh.core.model.FileThing;
import com.ywh.core.tool.FileToThing;

import java.io.File;
import java.sql.SQLException;

/**
 * @author ywh
 * @date 2019/11/26 21:40
 * @description 目的是写数据库，需要使用Dao包
 */
public class FileScanInterceptorImpl implements FileInterceptor {
    private final FileDao fileDao;

    public FileScanInterceptorImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public void apply(File file) {
        FileThing fileThing= FileToThing.transfer(file);
        try {
            fileDao.insert(fileThing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
