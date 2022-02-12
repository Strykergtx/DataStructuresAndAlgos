package LeetCode;


//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortMergeFunction {

        //2 pointer technique
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int fullSize = nums1.length-1;

            //pre decrement, decrease the value then assign it
            m = --m;
            n = --n;

            //use 2 pointer and compare from the endings of both num1 and nums2

            //use while until either nums1 or nums2 goes empty
            while(m>=0 && n>=0)
            {
                //normal 2 pointer comparison
                if(nums1[m]>=nums2[n])

                    //pick elements from nums1 put it back into finalArray from the end
                    nums1[fullSize--] = nums1[m--];

                else
                    //pick elements from nums2 put it back into finalArray from the end
                    nums1[fullSize--] = nums2[n--];

            }


            //only one of these whiles can execute not both for a given input set
            //just put in the remaining elements into the finalArray cos these subset of elements
            //are the smallest avaiable and already in ascending order.
            while(m>=0)
                nums1[fullSize--] = nums1[m--];

            while(n>=0)
                nums1[fullSize--] = nums2[n--];

        }

}
