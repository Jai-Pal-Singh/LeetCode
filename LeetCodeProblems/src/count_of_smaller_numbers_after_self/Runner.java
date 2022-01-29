package count_of_smaller_numbers_after_self;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,2,6,1};
        ArrayFunctions.print(solution.countSmaller(nums));
    }
}
