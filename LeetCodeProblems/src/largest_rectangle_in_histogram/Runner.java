package largest_rectangle_in_histogram;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        BasicFunctions.print(solution.largestRectangleArea(heights));
    }
}
