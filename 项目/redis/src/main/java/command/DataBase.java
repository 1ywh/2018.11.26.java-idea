package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ywh
 * @date 2019/11/18 11:21
 * @description
 */
public class DataBase {
    private static Map<String, List<String>> listMap = new HashMap<>();
    private static Map<String, Map<String, String>> hashMap = new HashMap<>();

    public static List<String> getList(String key) {
        List<String> list = listMap.get(key);
        if (list == null) {
            list = new ArrayList<>();
            listMap.put(key, list);
        }
        return list;
    }

    public static Map<String, String> getHash(String key) {
        Map<String, String> hash = hashMap.get(key);
        if (hash == null) {
            hash = new HashMap<>();
            hashMap.put(key, hash);
        }
        return hash;
    }
}
