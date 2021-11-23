package house_robber;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        BasicFunctions.print(new Solution().rob(nums));
    }    
}
