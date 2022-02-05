package contiguous_array;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 0, 1, 0 };
        BasicFunctions.print(s.findMaxLength(nums));
    }
}
