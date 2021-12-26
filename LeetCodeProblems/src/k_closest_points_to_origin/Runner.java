package k_closest_points_to_origin;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2));
    }
}
