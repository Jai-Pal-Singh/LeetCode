package a_distance_maximizing_problem;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        BasicFunctions.print(solution.maxIndexDiff(arr, arr.length));
    }
}
