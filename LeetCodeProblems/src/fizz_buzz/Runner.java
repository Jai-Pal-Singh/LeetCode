package fizz_buzz;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 15;
        ArrayFunctions.printListString(solution.fizzBuzz(n));
    }
}
