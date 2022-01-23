package redundant_connection;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}}));
    }
}
