package surrounded_regions;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        new Solution().solve(board);
        ArrayFunctions.print(board);   
    }
}
