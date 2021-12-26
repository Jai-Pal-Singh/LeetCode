package maximal_square;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().maximalSquare(new char[][] {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        }));
    }
}
