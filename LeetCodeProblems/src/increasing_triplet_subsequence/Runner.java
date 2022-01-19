package increasing_triplet_subsequence;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        BasicFunctions.print(solution.increasingTriplet(nums));
    }
}
