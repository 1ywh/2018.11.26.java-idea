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
 * @date 2019/11/18 13:08
 * @description
 */
public class LRANGECommand implements Command {
    private List<Object> args;

    private static final Logger logger = LoggerFactory.getLogger(LPUSHCommand.class);

    @Override
    public void runMethod(OutputStream out) throws Exception {
        String key = new String((byte[]) args.get(0));
        int start = Integer.parseInt(new String((byte[]) args.get(1)));
        int end = Integer.parseInt(new String((byte[]) args.get(2)));
        List<String> list = DataBase.getList(key);
        List<String> result = list.subList(start, end + 1);
        Protocol.writeArray(out,result);


    }


    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
