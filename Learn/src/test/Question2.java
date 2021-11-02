package test;

public class Question2 {
    public static void main(String[] args) {
        Question2 q2 = new Question2();

        System.out.println(q2.path(new int[][]{{2,5,10}, {4,8,9}, {1,3,8}}, 0, 0));
    }

    private int path(int[][] matrix, int i, int j) {
        if(i < matrix.length && j < matrix[0].length){
            int bottom = trailingZeros(path(matrix, i+1, j));
            int next = trailingZeros(path(matrix, i, j+1));
        }
        return 0;
    }

    private int trailingZeros(int path) {
        return 0;
    }
}
