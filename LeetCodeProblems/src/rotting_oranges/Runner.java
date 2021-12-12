package rotting_oranges;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        helper.BasicFunctions.print(solution.orangesRotting(grid));
    }
}
