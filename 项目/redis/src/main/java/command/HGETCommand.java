package command;

import ywh.Command;
import ywh.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author ywh
 * @date 2019/11/18 14:27
 * @description
 */
public class HGETCommand implements Command {
    private List<Object> args;

    @Override
    public void runMethod(OutputStream out) throws IOException {
        String key = new String((byte[]) args.get(0));
        String field = new String((byte[]) args.get(1));
        Map<String, String> hash = DataBase.getHash(key);
        String value = hash.get(field);
        if (value != null) {
            Protocol.writeBulkString(out, value);
        } else {
            Protocol.writeNull(out);
        }


    }

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
