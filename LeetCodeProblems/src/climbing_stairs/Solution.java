package climbing_stairs;

import java.util.ArrayList;
import java.util.List;

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Constraints:

// 1 <= n <= 45
//    Hide Hint #1  
// To reach nth step, what could have been your previous steps? (Think about the step sizes)
// Just like Fibonacci number

public class Solution {
    List<Integer> stairs;

    public int climbStairs(int n) {
        stairs = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            stairs.add(i, 0);
        }
        return getSteps(n);
    }

    private int getSteps(int n) {
        if (n < 3)
            return n;
        if (stairs.get(n) != 0)
            return stairs.get(n);
        int res = getSteps(n - 1) + getSteps(n - 2);
        stairs.add(n, res);
        return res;
    }
}
