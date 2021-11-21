package merge_sorted_array;

import helper.ArrayFunctions;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        ArrayFunctions.print(nums1);
    }
}
