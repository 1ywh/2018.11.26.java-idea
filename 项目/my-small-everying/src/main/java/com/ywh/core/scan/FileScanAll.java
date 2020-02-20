package com.ywh.core.scan;

import com.ywh.core.dao.DataBaseFactory;
import com.ywh.core.dao.LimitDaoImpl;
import com.ywh.core.dao.NoLimitDaoImpl;
import com.ywh.core.interceptor.FileInterceptor;
import com.ywh.core.interceptor.FileInterceptorImpl;
import com.ywh.core.interceptor.FileScanInterceptorImpl;

/**
 * @author ywh
 * @date 2019/11/25 18:41
 * @description 给一个路径进行遍历, 索引加拦截（可有可无，本来在实现类中）
 */
public interface FileScanAll {
    //遍历的path
    void fileScan(String Path);

    //遍历的拦截器
    void interceptor(FileInterceptor fileInterceptor);
}
