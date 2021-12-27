package unique_binary_search_trees;

import java.util.Arrays;

/* 
Given an integer n,return the number of structurally unique BST's(binary search trees)which has exactly n nodes of unique values from 1 to n.

Example 1:

Input:n=3 Output:5 Example 2:

Input:n=1 Output:1

Constraints:

1<=n<=19
 */
public class Solution {
    int[] dp;

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }

        dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                total += dp[left] * dp[right];
            }
            dp[nodes] = total;
        }

        return dp[n];
    }
}
