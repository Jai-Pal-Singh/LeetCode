package alien_dictionary;

import helper.ArrayFunctions;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayFunctions.print(s.getAlphabet(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
    }
}
