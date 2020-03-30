package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ywh
 * @date 2020/3/30 22:56
 * @description
 */
public class l_01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[]{map.get(a), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
