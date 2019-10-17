import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ywh
 * @date 2019/10/17 16:26
 * @description  牛牛找工作
 */
public class FindJob{
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        //先输入工作的数量n和小伙伴的数量m
        int n = sn.nextInt();
        int m = sn.nextInt();
        int[] n1 = new int[n];
        Map<Integer, Integer> hash = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = sn.nextInt();
            int b = sn.nextInt();
            hash.put(a, b);
        }
        Arrays.sort(n1);
        for (int i = 0; i < m; i++) {
            int c = sn.nextInt();
            n1[i]=c;
            if(!hash.containsKey(c)){
                hash.put(c,0);
            }
        }
        //更新最大的值
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> ent:hash.entrySet()){
            max=Math.max(max,ent.getValue());
            hash.put(ent.getKey(),max);
        }
        for(int i=0;i<n1.length;i++){
            System.out.println(hash.get(n1[i]));
        }
    }

}
