package min_cost_climbing_stairs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     List<Integer> stairsCost;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        stairsCost = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            stairsCost.add(i, 0);
        }
        stairsCost.add(0, cost[0]);
        stairsCost.add(1, cost[1]);
        getSteps(cost, n-1);
        return Math.min(stairsCost.get(n-1),stairsCost.get(n-2));

    }
    
    private int getSteps(int[] cost, int n) {
        if (n < 2 || stairsCost.get(n) != 0)
            return stairsCost.get(n);
        int res = Math.min(cost[n]+getSteps(cost, n-2), cost[n]+getSteps(cost, n-1));
        stairsCost.add(n, res);
        return res;
    }
}
