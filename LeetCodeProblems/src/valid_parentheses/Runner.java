package valid_parentheses;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        helper.BasicFunctions.print(solution.isValid("()"));
        helper.BasicFunctions.print(solution.isValid("()[]{}"));
        helper.BasicFunctions.print(solution.isValid("(]"));
        helper.BasicFunctions.print(solution.isValid("([)]"));
        helper.BasicFunctions.print(solution.isValid("{[]}"));
    }
}
