package minimum_path_sum;

import java.util.Arrays;

/* 
Given a m x n grid filled with non-negative numbers,find a path from top left to bottom right,which minimizes the sum of all numbers along its path.

Note:You can only move either down or right at any point in time.

Example 1:

Input:grid=[[1,3,1],[1,5,1],[4,2,1]]Output:7 Explanation:Because the path 1→3→1→1→1 minimizes the sum.Example 2:

Input:grid=[[1,2,3],[4,5,6]]Output:12

Constraints:

m==grid.length n==grid[i].length 1<=m,n<=200 0<=grid[i][j]<=100

 */
public class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            Arrays.fill(dp[i], -1);
        return minPathSum(grid, m - 1, n - 1, 0, 0);
    }

    public int minPathSum(int[][] grid, int m, int n, int r, int c) {
        if (r == m && c == n)
            return grid[r][c];
        if (dp[r][c] != -1)
            return dp[r][c];
        if (r <= m && c <= n) {
            dp[r][c] = grid[r][c] + Math.min(minPathSum(grid, m, n, r, c + 1), minPathSum(grid, m, n, r + 1, c));
            return dp[r][c];
        }
        return Integer.MAX_VALUE;
    }
}
