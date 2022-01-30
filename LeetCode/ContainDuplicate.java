package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
        //https://leetcode.com/problems/contains-duplicate/
        //store in hashset check if it exists
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> ht = new HashSet<>();
            for (int i = 0; i < (nums.length); i++) {
                if (!ht.add(nums[i]))
                    return true;

            }
            return false;
        }

}