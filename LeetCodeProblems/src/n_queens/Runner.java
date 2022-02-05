package n_queens;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.printListListString(new Solution().solveNQueens(4));
    }
}
