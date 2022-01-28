package word_break_ii;

import java.util.Arrays;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayFunctions.printListString(solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
