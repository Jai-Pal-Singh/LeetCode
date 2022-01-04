package interval_list_intersections;

public class Runner {
    public static void main(String[] args) {
        helper.ArrayFunctions.print(new Solution().intervalIntersection(new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }
}
