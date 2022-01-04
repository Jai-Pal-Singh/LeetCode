package backspace_string_compare;

public class Runner {
    public static void main(String[] args) {
        helper.BasicFunctions.print(new Solution().backspaceCompare("ab#c", "ad#c"));
        helper.BasicFunctions.print(new Solution2().backspaceCompare("ab##", "c#d#"));
    }
}
