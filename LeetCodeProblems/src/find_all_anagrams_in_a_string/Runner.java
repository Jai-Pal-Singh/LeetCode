package find_all_anagrams_in_a_string;

import helper.ArrayFunctions;
public class Runner {
    public static void main(String[] args) {
        ArrayFunctions.print(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}
