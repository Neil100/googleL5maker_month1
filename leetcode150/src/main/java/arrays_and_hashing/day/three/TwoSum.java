package arrays_and_hashing.day.three;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        int[] sol = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(set.get(nums[i])!=null) {
                sol[0] = set.get(nums[i]);
                sol[1] = i;
                return sol;
            }

            set.put(target-nums[i], i);
        }

        return sol;
    }
}
