package unique_paths_ii;

public class Runner {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        helper.BasicFunctions.print(new Solution().uniquePathsWithObstacles(grid));
    }
}
