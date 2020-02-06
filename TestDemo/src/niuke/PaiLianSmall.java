package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static sort.QuickSort.swap;

/**
 * @author ywh
 * @date 2020/1/17 10:02
 * @description   排列数字
 */
public class PaiLianSmall {
    public static String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1 +""+ o2;
                String b = o2 +""+ o1;
                return a.compareTo(b);
            }
        });
        String s="";
       for(int j:list){
           s=s+j;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{1,99,44}));
    }


}
