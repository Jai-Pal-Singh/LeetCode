package longest_increasing_path_in_a_matrix;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        BasicFunctions.print(s.longestIncreasingPath(matrix));
    }
}
