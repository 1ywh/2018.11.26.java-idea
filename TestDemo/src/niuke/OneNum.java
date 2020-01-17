package niuke;

/**
 * @author ywh
 * @date 2020/1/17 14:01
 * @description  牛客:找逆序对
 */
public class OneNum {
    private static int k;

    public static int InversePairs(int[] array) {
        if (array.length == 0 ) {
            return 0;
        }
        merge(array, 0, array.length - 1);
        return k;
    }

    public static void merge(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        mergeInner(arr, left, mid, right);
    }

    public static void mergeInner(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int[] extra = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] > arr[p2]) {
                extra[i++] = arr[p2++];
                k = (k + (mid - p1 + 1)) % 1000000007;
            } else {
                extra[i++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            extra[i++] = arr[p1++];
        }
        while (p2 <= right) {
            extra[i++] = arr[p2++];
        }
        for (i = 0; i < extra.length; i++) {
            arr[i + left] = extra[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{4,3,2,1}));
    }
}
