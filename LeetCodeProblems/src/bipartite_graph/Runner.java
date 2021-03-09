package bipartite_graph;
/**
 * @author hp
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
//			{{1,2,3},{0,2},{0,1,3},{0,2}};
		Solution solution = new Solution();
		System.out.println(solution.isBipartite(grid));
			}

}
