package course_schedule;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution obj = new Solution();
        BasicFunctions.print(obj.canFinish(2, new int[][]{{1,0}}));
        BasicFunctions.print(obj.canFinish(2, new int[][]{{1,0},{0,1}}));
    }
}
