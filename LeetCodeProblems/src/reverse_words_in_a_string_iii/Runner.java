package reverse_words_in_a_string_iii;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Let's take LeetCode contest";
        BasicFunctions.print(solution.reverseWords(s));
    }
    
}
