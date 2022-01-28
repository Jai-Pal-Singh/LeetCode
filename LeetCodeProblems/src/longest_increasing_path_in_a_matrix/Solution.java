package longest_increasing_path_in_a_matrix;

import java.util.Arrays;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
 */

public class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }
    
    public int dfs(int[][] matrix, int i, int j) {
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int ans = 1;
        int[] x = new int[]{-1, 0, 1, 0};
        int[] y = new int[]{0, 1, 0, -1};
        for(int k = 0; k<4; k++){
            if((i+x[k])>=0 && (i+x[k])<matrix.length && (j+y[k])>=0 && (j+y[k])<matrix[i].length 
               && matrix[i+x[k]][j+y[k]] > matrix[i][j]){
                ans = Math.max(ans, dfs(matrix, i+x[k], j+y[k])+1);
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
