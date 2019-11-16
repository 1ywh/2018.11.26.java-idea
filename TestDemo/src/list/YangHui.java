package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywh
 * @date 2019/11/12 22:20
 * @descriptionhttps: 杨辉三角//leetcode-cn.com/problems/pascals-triangle/submissions/
 */
public class YangHui {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = null;
        if (numRows == 0) {
            return result;
        } else {
            list = new ArrayList<>();
            list.add(1);
            result.add(list);
        }

        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            List<Integer> list1 = result.get(i - 1);
            for (int j = 0; j <= i - 2; j++) {
                int a = list1.get(j) + list1.get(j + 1);
                list.add(a);
            }
            list.add(1);
            result.add(list);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}