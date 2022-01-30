package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

         //https://leetcode.com/problems/two-sum/
        //O(n) solution
        public int[] twoSum(int[] nums, int target) {

            Map<Integer,Integer> complement = new HashMap<>();

            int[] ans = new int[2];

            for(int i = 0;i< nums.length;i++)
            {
                if(complement.containsKey(nums[i]))
                { ans[0]=complement.get(nums[i]);
                    ans[1]=i;

                }
                complement.put((target-nums[i]),i);
            }

            return ans;
        }
}
