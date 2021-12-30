package word_break;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        helper.BasicFunctions.print(new Solution().wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    }
}
