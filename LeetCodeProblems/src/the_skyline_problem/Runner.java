package the_skyline_problem;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        ArrayFunctions.printList(new Solution().getSkyline(buildings));
    }
}
