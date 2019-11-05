package day1;

/**
 * @author ywh
 * @date 2019/11/5 22:01
 * @description
 *
 */

import java.util.*;

public class day1_2 {
    public static int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n - K];
    }

}