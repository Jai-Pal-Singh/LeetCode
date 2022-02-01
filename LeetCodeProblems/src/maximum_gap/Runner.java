package maximum_gap;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 3, 6, 9, 1 };
        BasicFunctions.print(s.maximumGap(nums));
    }
}
