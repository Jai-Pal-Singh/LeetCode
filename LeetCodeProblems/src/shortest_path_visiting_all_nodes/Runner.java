package shortest_path_visiting_all_nodes;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        BasicFunctions.print(solution.shortestPathLength(graph));
    }
}
