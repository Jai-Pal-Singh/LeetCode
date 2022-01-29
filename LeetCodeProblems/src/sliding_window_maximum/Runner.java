package sliding_window_maximum;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        ArrayFunctions.print(new Solution().maxSlidingWindow(nums, 3));
    }
}
