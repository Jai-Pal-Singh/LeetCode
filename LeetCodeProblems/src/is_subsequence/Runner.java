package is_subsequence;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        helper.BasicFunctions.print(solution.isSubsequence("abc", "ahbgdc"));
        helper.BasicFunctions.print(solution.isSubsequence("axc", "ahbgdc"));
    }
}
