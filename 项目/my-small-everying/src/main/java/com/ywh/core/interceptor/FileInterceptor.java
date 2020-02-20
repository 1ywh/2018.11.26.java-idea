package com.ywh.core.interceptor;

import jdk.nashorn.internal.objects.annotations.Function;

import java.io.File;

/**
 * @author ywh
 * @date 2019/11/26 21:06
 * @description  拦截器
 */
@FunctionalInterface
//函数式接口
public interface FileInterceptor {
    void apply(File file);
}
