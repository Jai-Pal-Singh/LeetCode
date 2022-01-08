package all_paths_from_source_to_target;

import java.util.List;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = new int[][] {
            {1, 2},
            {3},
            {3},
            {}
        };
        List<List<Integer>> res = solution.allPathsSourceTarget(graph);
        ArrayFunctions.printList(res);
    }
}
