package test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Question2 {

    private static Logger log = Logger.getLogger(Question2.class.getName());
    public static void main(String[] args) {

        log.log(Level.INFO, "Output : {0}", new Question2().path(new int[][]{{2,5,10}, {4,8,9}, {1,3,8}}, 0, 0));
    }

    private int path(int[][] matrix, int i, int j) {
        if(i < matrix.length && j < matrix[0].length){
            int bottom = trailingZeros(path(matrix, i+1, j));
            int next = trailingZeros(path(matrix, i, j+1));
            return Math.min(bottom, next);
        }
        return 0;
    }

    private int trailingZeros(int path) {
        return path;
    }
}
