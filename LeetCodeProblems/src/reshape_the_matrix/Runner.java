package reshape_the_matrix;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        helper.ArrayFunctions.print(new Solution().matrixReshape(matrix, r, c));
    }
}
