package game_of_life;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0, }
        };
        new Solution().gameOfLife(board);
        ArrayFunctions.print(board);
    }
}
