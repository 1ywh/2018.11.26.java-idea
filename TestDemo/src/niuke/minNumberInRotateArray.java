package niuke;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ywh
 * @date 2019/12/2 23:25
 * @description      数组中最小的数字
 */
public class minNumberInRotateArray {
    public int m(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        return arr[0];
    }

    public int m1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        for (; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }
    public int m3(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int a : array) {
            p.add(a);
        }
        return p.poll();
    }
}
