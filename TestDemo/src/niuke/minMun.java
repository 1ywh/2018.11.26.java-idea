package niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ywh
 * @date 2020/1/16 23:47
 * @description
 */
public class minMun{
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(input.length==0||k<0){
            return list;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[]{1999,2,3,4,5,},9));
    }
}