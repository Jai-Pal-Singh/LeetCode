package course_schedule_ii;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        ArrayFunctions.print(solution.findOrder(numCourses, prerequisites));
    }
}
