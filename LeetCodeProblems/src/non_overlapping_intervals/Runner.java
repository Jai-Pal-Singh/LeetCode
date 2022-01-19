package non_overlapping_intervals;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        BasicFunctions.print(solution.eraseOverlapIntervals(intervals));
    }
}
