package ransom_note;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        helper.BasicFunctions.print(solution.canConstruct("a", "b"));
        helper.BasicFunctions.print(solution.canConstruct("aa", "ab"));
        helper.BasicFunctions.print(solution.canConstruct("aa", "aab"));
    }
}
