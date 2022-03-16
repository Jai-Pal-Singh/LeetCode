package validate_stack_sequences;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        BasicFunctions.print(solution.validateStackSequences(pushed, popped));
    }
}
