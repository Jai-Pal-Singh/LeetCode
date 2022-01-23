package wiggle_sort_ii;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 5, 1, 1, 6, 4};
        s.wiggleSort(nums);
        ArrayFunctions.print(nums);
    }
}
