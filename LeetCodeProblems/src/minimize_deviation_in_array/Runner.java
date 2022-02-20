package minimize_deviation_in_array;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        BasicFunctions.print(solution.minimumDeviation(nums));
    }
}
