package min_cost_climbing_stairs;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] cost = {0,1,1,0};
        BasicFunctions.print(new Solution().minCostClimbingStairs(cost));
    }    
}
