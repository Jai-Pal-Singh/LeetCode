package _01_matrix;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {  {1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, 
                            {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, 
                            {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, 
                            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, 
                            {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, 
                            {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, 
                            {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, 
                            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, 
                            {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, 
                            {1, 1, 1, 1, 0, 1, 0, 0, 1, 1} };
        helper.ArrayFunctions.print(new Solution().updateMatrix(matrix));
    }
}
