package remove_covered_intervals;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,4},{3,6},{2,8}};
        BasicFunctions.print(solution.removeCoveredIntervals(intervals));
    }
}
