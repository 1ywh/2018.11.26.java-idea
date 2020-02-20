package command;

import ywh.Command;
import ywh.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author ywh
 * @date 2019/11/18 11:01
 * @description
 */
public class HSETCommand implements Command {
    private List<Object> args;

    @Override
    public void runMethod(OutputStream out) throws IOException {
        String key = new String((byte[]) args.get(0));
        String field = new String((byte[]) args.get(1));
        String value = new String((byte[]) args.get(2));
        Map<String, String> hash = DataBase.getHash(key);
        boolean isUpdate = hash.containsKey(field);
        hash.put(field, value);
        if(isUpdate){
            Protocol.writeInteger(out,0);
        }else{
            Protocol.writeInteger(out,1);
        }

    }

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }


}
