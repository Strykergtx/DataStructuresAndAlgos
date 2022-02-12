package LeetCode;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {

       //Normal Kadane's algorithm
       //Edge case -[-2,-1], [-1], [-1,-2], [1,-2,-3,4,-1,4,6,-8,-3]
        public int maxSubArray(int[] nums) {

            int max =-10000;
            int currentMax =0;

            for(int i = 0;i<(nums.length);i++)
            {

                currentMax=currentMax+ nums[i];

                if(max<currentMax)
                    max = currentMax;

                if(currentMax<=0)
                    currentMax = 0;

            }

            return max;
        }

}
