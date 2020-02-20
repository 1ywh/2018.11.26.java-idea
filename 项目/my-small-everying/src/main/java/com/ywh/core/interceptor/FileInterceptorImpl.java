package com.ywh.core.interceptor;

import java.io.File;

/**
 * @author ywh
 * @date 2019/11/26 21:09
 * @description
 */
public class FileInterceptorImpl  implements FileInterceptor{

    @Override
    public void apply(File file) {
        System.out.println(file.getAbsolutePath());
    }
}
