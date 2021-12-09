package longest_common_subsequence;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        helper.BasicFunctions.print(solution.longestCommonSubsequence("abcde", "ace"));
        helper.BasicFunctions.print(solution.longestCommonSubsequence("abc", "abc"));
        helper.BasicFunctions.print(solution.longestCommonSubsequence("abc", "def"));
    }
}
