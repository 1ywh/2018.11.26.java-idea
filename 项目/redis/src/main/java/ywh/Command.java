package ywh;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 命令相关
 * Author:ywh
 * Date:2019/11/14
 */
public interface Command {

    //打印所有的args
    void runMethod(OutputStream out) throws Exception;

    void setArgs(List<Object> args);
}
