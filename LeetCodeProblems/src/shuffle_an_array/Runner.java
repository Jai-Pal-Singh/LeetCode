package shuffle_an_array;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[] { 1, 2, 3 });
        ArrayFunctions.print(solution.shuffle());
        ArrayFunctions.print(solution.reset());
        ArrayFunctions.print(solution.shuffle());
    }
}
