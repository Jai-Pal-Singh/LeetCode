package matrix_block_sum;

public class Runner {
    public static void main(String[] args) {
        // int[][] matrix = new int[][]{
        //         {3, 0, 1, 4, 2},
        //         {5, 6, 3, 2, 1},
        //         {1, 2, 0, 1, 5},
        //         {4, 1, 0, 1, 7},
        //         {1, 0, 3, 0, 5}
        // };
        // int[][] matrix2 = new int[][]{
        //         {67,64,78},
        //         {99,98,38},
        //         {82,46,46},
        //         {6,52,55},
        //         {55,99,45}
        // };
        int[][] matrix3 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        helper.ArrayFunctions.print(new Solution().matrixBlockSum(matrix3,1));
    }
}
