package first_missing_positive;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        BasicFunctions.print(new Solution().firstMissingPositive(nums));
    }
}
