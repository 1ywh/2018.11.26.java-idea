package niuke;

/**
 * @author ywh
 * @date 2019/11/29 17:49
 * @description   数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 */
public class ComNumInArr_03 {

    public boolean test(int[] arr, int length, int[] pre) {
        if (arr == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    pre[0] = arr[i];
                    return true;
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return false;
    }

    private void swap(int[] arr, int i, int i1) {
        int t = arr[i];
        arr[i] = arr[i1];
        arr[i1] = t;
    }
}
