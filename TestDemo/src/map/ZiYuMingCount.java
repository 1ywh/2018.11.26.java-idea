package map;

import java.util.*;

/**
 * @author ywh
 * @date 2019/11/12 22:10
 * @description
 */
public class ZiYuMingCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            //空格分开
            String[] a = cpdomains[i].split(" ");
            int n = Integer.valueOf(a[0]);
            //点分开
            String[] b = a[1].split("\\.");
            //将其切开
            for (int j = 0; j < b.length; j++) {
                String[] c = Arrays.copyOfRange(b, j, b.length);
                String p = String.join(".", c);

                int o = map.getOrDefault(p, 0);
                map.put(p, n + o);
            }
        }
        for (Map.Entry<String, Integer> l : map.entrySet()) {
            String value = l.getKey();
            int key = l.getValue();
            list.add(key + " " + value);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] a = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(a));
        System.out.println();
    }
}