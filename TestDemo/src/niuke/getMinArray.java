package niuke;

/**
 * @author ywh
 * @date 2020/2/3 8:59
 * @description  旋转中数组的最小值
 */
public class getMinArray{
    public int minNumberInRotateArray(int [] array) {
        int r=array.length-1;
        int l=0;
        while(l<r){
            if(array[l]<array[r]){
                return array[l];
            }
            int mid=l+(r-l)>>1;
            if(array[l]<array[mid]){
                l=mid+1;
            }else if(array[r]>array[mid]){
                r=mid;
            }else{
                l++;
            }

        }
        return array[l];
    }
}