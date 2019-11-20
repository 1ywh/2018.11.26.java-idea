package sort;

/**
 * @author ywh
 * @date 2019/11/17 9:24
 * @description 找出无序区间最小的k个数
 */
public class FindMinNum {
    public static int[] getMinNumByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) return arr;
        int[] kHeap = new int[k];
        //先将前k个数字建堆
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        //将之后的数字每次比较然后插入
        for (int i = k; i!= arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    //每次插入都建立堆
    private static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //向下调整建大堆
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 64, 55, 7, 6, 5, 4};
        int[] aa = getMinNumByHeap(a, 3);
        for (int aaa : aa) {
            System.out.println(aaa);
        }
    }
}
