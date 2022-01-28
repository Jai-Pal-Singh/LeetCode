package wildcard_matching;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        String s = "ab";
        String p = "a?";
        BasicFunctions.print(new Solution().isMatch(s, p));
    }
}
