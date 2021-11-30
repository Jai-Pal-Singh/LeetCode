package flood_fill;

public class Runner {
    public static void main(String[] args) {
        int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        helper.ArrayFunctions.print(new Solution().floodFill(image, sr, sc, newColor));
    }
}
