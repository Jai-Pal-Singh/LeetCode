package minimum_number_of_arrows_to_burst_balloons;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        helper.BasicFunctions.print(solution.findMinArrowShots(points));
        helper.BasicFunctions.print(solution.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
}
