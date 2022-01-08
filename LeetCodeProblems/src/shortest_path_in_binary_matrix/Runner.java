package shortest_path_in_binary_matrix;
/**
 * 
 */

/**
 * @author hp
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
		int[][] grid = {
			{0,0,1,0,1,1},
			{1,0,0,1,0,0},
			{0,1,0,1,0,0},
			{1,0,1,0,0,0},
			{0,1,0,1,0,0},
			{0,0,0,0,0,0}};
		Solution solution = new Solution();
		helper.BasicFunctions.print(solution.shortestPathBinaryMatrix(grid));
	}

}
