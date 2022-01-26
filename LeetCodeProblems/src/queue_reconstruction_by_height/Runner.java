package queue_reconstruction_by_height;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        ArrayFunctions.print(new Solution().reconstructQueue(people));
    }
}
