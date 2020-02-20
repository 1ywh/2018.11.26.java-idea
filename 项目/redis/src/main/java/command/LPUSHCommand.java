package command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ywh.Command;
import ywh.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author ywh
 * @date 2019/11/18 11:01
 * @description
 */
public class LPUSHCommand implements Command {
    private List<Object> args;

    private  static final Logger logger=  LoggerFactory.getLogger(LPUSHCommand.class);
    @Override
    public void runMethod(OutputStream out) throws IOException {

        if (args.size() != 2) {
            Protocol.writeError(out, " 至少俩个参数");
            return;
        }
        String key = new String((byte[]) args.get(0));
        String value = new String((byte[]) args.get(1));
        logger.debug("运行的是lpush命令：{}{}",key,value);
        List<String> list = DataBase.getList(key);
        list.add(0, value);
        logger.debug("{ }",list.size());
        Protocol.writeInteger(out, list.size());
    }

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
