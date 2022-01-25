package _4sum_ii;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        BasicFunctions.print(new Solution().fourSumCount(nums1, nums2, nums3, nums4));
    }
}
