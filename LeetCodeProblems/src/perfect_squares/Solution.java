package perfect_squares;

import java.util.Arrays;

/* 
Given an integer n,return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer;in other words,it is the product of some integer with itself.For example,1,4,9,and 16 are perfect squares while 3 and 11 are not.

Example 1:

Input:n=12 Output:3 Explanation:12=4+4+4. Example 2:

Input:n=13 Output:2 Explanation:13=4+9.

Constraints:

1<=n<=104
 */
public class Solution {
    public int numSquares(int n) {
        int[] perfectSquares = new int[(int) Math.sqrt(n)];
        for (int i = 0; i < perfectSquares.length; i++) {
            perfectSquares[i] = (i + 1) * (i + 1);
        }
        return coinChange(perfectSquares, n);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
