/**
 * 二分查找
 * 左闭右闭
 * 左闭右开
 * Author:ywh
 * Date:2019/03/31
 */
public class binarySort {
    //[left,right)
     public static int Open(int[] arr, int num) {
        int left = 0;
        int right = arr.length;
        // int right = arr.length-1;
        // while (left <=right) {
            while(left<right){
            int mid = left + (right-left) / 2;
            System.out.println(mid);
            if (num == arr[mid]) {
                return mid;
            }
            if (num < arr[mid]) {
                right = mid;
                //right = mid-1;
            }
            if (num > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Open(new int[]{1,2,3,4,5,6,7},3));

    }
}
