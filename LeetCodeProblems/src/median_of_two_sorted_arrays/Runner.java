package median_of_two_sorted_arrays;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        BasicFunctions.print(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
