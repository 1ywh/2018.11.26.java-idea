package q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ywh
 * @date 2019/9/16 19:50
 * @description
 */
public class Solution {
    public static List<List<Integer>> tree(int[] num) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            int k = num.length - 1;
            int j = i + 1;
            while (j < k) {
                int s = num[i] + num[j] + num[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    lists.add(list);
                    j++;
                }


            }
        }


        return lists;

    }

    public static void main(String[] args) {
        int[] nums = {-3, -2 - 6, 0, 1, 2, 3};
        Arrays.sort(nums);
        System.out.println(tree(nums));
    }
}
