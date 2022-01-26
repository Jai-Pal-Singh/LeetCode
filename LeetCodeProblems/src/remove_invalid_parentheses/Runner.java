package remove_invalid_parentheses;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.printListString(new Solution().removeInvalidParentheses("()())()"));
        ArrayFunctions.printListString(new Solution().removeInvalidParentheses(")("));
    }
}
