package two_sum_II;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        ArrayFunctions.print(new Solution().twoSum(nums, target));
    }
}
