package merge_intervals;

public class Runner {
    public static void main(String[] args) {
        helper.ArrayFunctions.print(new Solution().merge(new int[][] {
            { 1, 3 },
            { 2, 6 },
            { 8, 10 },
            { 15, 18 }
        }));
    }
}
