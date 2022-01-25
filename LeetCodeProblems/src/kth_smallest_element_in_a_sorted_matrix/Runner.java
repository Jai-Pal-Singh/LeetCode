package kth_smallest_element_in_a_sorted_matrix;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        BasicFunctions.print(new Solution().kthSmallest(matrix, k));
    }
}
