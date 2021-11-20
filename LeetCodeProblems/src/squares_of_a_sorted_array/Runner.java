package squares_of_a_sorted_array;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        ArrayFunctions.print(new Solution().sortedSquares(nums));
        ArrayFunctions.print(new Solution2().sortedSquares(nums));
    }
}
