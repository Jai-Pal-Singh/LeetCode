package verifying_an_alien_dictionary;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
