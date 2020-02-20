package com.ywh.core.interceptor;

import com.ywh.core.model.FileThing;

/**
 * @author ywh
 * @date 2019/12/1 16:23
 * @description
 */
@FunctionalInterface
public interface FileThingInterceptor {
    void apply(FileThing fileThing);
}
