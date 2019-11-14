package sort;

/**
 * @author ywh
 * @date 2019/11/13 18:34
 * @description
 */
public class QuickSort {
    public static int[] partition(int[] arr, int left, int right) {
        //第一个数的左边界为小区域
        int l = left - 1;
        int r = right;
        //左边界的最右边的指针
        while (left < r) {
            if (arr[left] < arr[right]) {
                //小于的话交换，相当于不交换，因为指针在同一个位置
                swap(arr, ++l, left++);
            } else if (arr[left] > arr[right]) {
                //将该值放到右边界（不包括right指向的，把他当作基准值来看）
                swap(arr, --r, left);
            } else {
                //相等的话左走右不动
                left++;
            }
        }
        //回到正确的，将基准值换回来
        swap(arr, right, r);
        return new int[]{l+1,r};
    }
    public static void swap(int[] arr, int l, int r) {
//        arr[l] = arr[l] ^ arr[r];
//        arr[r] = arr[l] ^ arr[r];
//        arr[l] = arr[l] ^ arr[r];
        int a=arr[l];
        arr[l]=arr[r];
        arr[r]=a;
    }

    public static void sort(int[] arr1, int l, int r) {
        if (l < r) {
          //  swap(arr1,l+(int)(Math.random()*(r-l+1)),r);
            int[] par = partition(arr1, l, r);
            sort(arr1, l, par[0] - 1);
            sort(arr1, par[1]+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 3, 22, 4, 4};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
