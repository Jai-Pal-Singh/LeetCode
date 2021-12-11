package minimum_falling_path_sum;

public class Runner {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        helper.BasicFunctions.print(new Solution().minFallingPathSum(input));
    }
}
