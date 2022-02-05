package maximum_profit_in_job_scheduling;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] startTime = new int[] {1, 1, 1};
        int[] endTime = new int[] {2, 3, 4};
        int[] profit = new int[] {5, 6, 4};
        BasicFunctions.print(new Solution().jobScheduling(startTime, endTime, profit));
    }
}
