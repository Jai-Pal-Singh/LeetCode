package tiling_a_rectangle_with_the_fewest_squares;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().tilingRectangle(11, 13));
        BasicFunctions.print(new Solution().tilingRectangle(5, 6));
    }
}
