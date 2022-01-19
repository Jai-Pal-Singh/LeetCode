package minimum_number_of_vertices_to_reach_all_nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges.add(new ArrayList<>(Arrays.asList(4, 2)));
        List<Integer> res = solution.findSmallestSetOfVertices(n, edges);
        ArrayFunctions.print(res);
    }
}
