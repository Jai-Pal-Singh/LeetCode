package word_pattern;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        BasicFunctions.print(solution.wordPattern("abba", "dog cat cat dog"));
        BasicFunctions.print(solution.wordPattern("abba", "dog cat cat fish"));
        BasicFunctions.print(solution.wordPattern("aaaa", "dog cat cat dog"));
    }
}
