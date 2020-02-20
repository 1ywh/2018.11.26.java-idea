package com.ywh.core.scan;

import com.ywh.config.EverythingConfig;
import com.ywh.core.interceptor.FileInterceptor;
import java.io.File;
import java.util.LinkedList;

/**
 * @author ywh
 * @date 2019/11/25 18:42
 * @description 逐个遍历、组合在一起，主要是对文件做拦截处理
 * 遍历加应用
 */
public class FileScanAllImpl implements FileScanAll {

    //使用Config中的来删除
    private EverythingConfig config = EverythingConfig.getInstance();

    //写一个拦截器,很多个,最后添加一个方法
    private LinkedList<FileInterceptor> interceptors = new LinkedList<>();

    //进行Config中的排除，递归处理
    @Override
    public void fileScan(String path) {
        File file = new File(path);
        //如果是文件的话就加入
        if (file.isFile()) {
            //判断到底是不是排除的
            if (config.getExcludePath().contains(file.getParent())) {
                return;
            }
        } else {
            if (config.getExcludePath().contains(path)) {
                return;
            } else {
                //如果是目录的话就遍历
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        fileScan(f.getAbsolutePath());
                    }
                }
            }
        }
        //不管是文件还是目录，最后都做一个拦截处理
        for (FileInterceptor interceptor : this.interceptors) {
            interceptor.apply(file);
        }

        //文件变成Thing，写到数据库
        //拦截器方法
    }

    @Override
    public void interceptor(FileInterceptor fileInterceptor) {
        this.interceptors.add(fileInterceptor);
    }

}