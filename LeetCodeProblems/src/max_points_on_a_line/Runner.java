package max_points_on_a_line;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        // BasicFunctions.print(new Solution().maxPoints(new int[][]{{2,3},{3,3},{-5,3}}));
        BasicFunctions.print(new Solution().maxPoints(new int[][]{{0,0},{1,-1},{1,1}}));
    }
}
