package task_scheduler;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        BasicFunctions.print(new Solution().leastInterval(tasks, n));
    }
}
