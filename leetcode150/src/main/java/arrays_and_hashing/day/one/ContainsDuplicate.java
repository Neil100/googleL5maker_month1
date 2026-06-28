package arrays_and_hashing.day.one;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean h = false;
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]) || h) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
