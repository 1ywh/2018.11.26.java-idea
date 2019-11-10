package one;

/**
 * @author ywh
 * @date 2019/11/10 23:21
 * @description  给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数
 * 使用快排
 */
public class FindK {

    public int partition(int[] arr, int left, int right) {
        int pv = arr[right];
        while (left < right) {
            while (left < right && arr[left] >= pv) {
                left++;
            }
            arr[right] = arr[left];
            while (left < right && arr[right] <= pv) {
                right--;
            }
            arr[left] = arr[right];
        }

        arr[left] = pv;
        return left;
    }

    public int findKth(int[] a, int l, int h, int K) {
        int part = partition(a, l, h);
        if (K == part - l + 1) {
            return a[part];
        } else if (K < part - l + 1) {
            return findKth(a, l, part - 1, K);
        } else {
            return findKth(a, part + 1, h, K - part + l - 1);
        }
    }

    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, K);
    }
}

