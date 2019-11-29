package niuke;

/**
 * @author ywh
 * @date 2019/11/29 16:46
 * @description 输入一个数字，在二维数组中查找看是否有该数字
 */
public class FindArray_02 {
    public boolean Find(int target, int[][] array) {

        //方法一：使用二分查找的方法
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int right = array[i].length;
            while (low < right) {
                int mid = low + (right - low) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    right = mid;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean Find1(int target, int [][] array) {
        int row=array.length;
        if(row==0){
            return false;
        }
        int col=array[0].length;
        if(col==0){
            return false;
        }
        int rows=0;
        int cols=col-1;
        while(rows<row&&cols>=0){
            int a=array[rows][cols];
            if(target==a){
                return true;
            }else if(a>target){
                cols--;
            }else{
                rows++;
            }
        }
        return false;
    }
}

