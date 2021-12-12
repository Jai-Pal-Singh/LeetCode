package letter_case_permutation;

public class Runner {
    public static void main(String[] args) {
        helper.ArrayFunctions.printListString(new Solution().letterCasePermutation("a1b2"));
        helper.ArrayFunctions.printListString(new Solution2().letterCasePermutation("a1b2"));
    }
}
