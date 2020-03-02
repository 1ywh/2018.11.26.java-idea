package leetcode;

/**
 * @author ywh
 * @date 2020/3/2 22:52
 * @description  删除排序数组中的重复项
 */
class removeDup {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[count]){
                count++;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2,3}));
    }
}
