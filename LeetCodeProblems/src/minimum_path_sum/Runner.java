package minimum_path_sum;

public class Runner {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        helper.BasicFunctions.print(new Solution().minPathSum(grid));
    }
}
