package integer_break;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >=
 * 2, and maximize the product of those integers.
 * 
 * Return the maximum product you can get.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * 
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 58
 */
public class Solution {

    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            int max = i;
            for (int j = 1; j <= i / 2; j++) {
                int index = i - j;
                max = Math.max(max, dp[index] * dp[i - index]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}