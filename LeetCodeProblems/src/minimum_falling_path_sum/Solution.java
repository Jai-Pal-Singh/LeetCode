package minimum_falling_path_sum;

import java.util.Arrays;

/* 
Given an n x n array of integers matrix,return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.Specifically,the next element from position(row,col)will be(row+1,col-1),(row+1,col),or(row+1,col+1).

Example 1:

Input:matrix=[[2,1,3],[6,5,4],[7,8,9]]Output:13 Explanation:There are two falling paths with a minimum sum as shown.Example 2:

Input:matrix=[[-19,57],[-40,-5]]Output:-59 Explanation:The falling path with a minimum sum is shown.

Constraints:

n==matrix.length==matrix[i].length 1<=n<=100-100<=matrix[i][j]<=100
 */
public class Solution {
    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            min = Math.min(min, minFallingPathSum(matrix, n - 1, 0, i));
        }
        return min;
    }

    public int minFallingPathSum(int[][] matrix, int n, int r, int c) {
        if (r == n && (c > -1 && c <= n)) {
            dp[r][c] = matrix[r][c];
            return dp[r][c];
        }
        if (r >= 0 && c >= 0 && r <= n && c <= n) {
            if (dp[r][c] != Integer.MAX_VALUE) {
                return dp[r][c];
            } else {
                dp[r][c] = matrix[r][c] + (Math.min(
                        minFallingPathSum(matrix, n, r + 1, c),
                        Math.min(minFallingPathSum(matrix, n, r + 1, c - 1),
                                minFallingPathSum(matrix, n, r + 1, c + 1))));
                return dp[r][c];
            }
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
