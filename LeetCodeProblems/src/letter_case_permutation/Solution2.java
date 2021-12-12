package letter_case_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> letterCasePermutation(String str) {
        Integer length = str.length();
        Set<String> permutations = new HashSet<>();
        generatePermutations(str.toCharArray(), 0, length, permutations);
        if (permutations.isEmpty())
            permutations.add(str);
        return new ArrayList<>(permutations);
    }

    private void generatePermutations(char[] s, Integer index, Integer length, Set<String> permutations) {
        if (index < length) {
            if (Character.isDigit(s[index])) {
                generatePermutations(s, index + 1, length, permutations);
            } else {
                s[index] = Character.toUpperCase(s[index]);
                permutations.add(String.valueOf(s));
                generatePermutations(s, index + 1, length, permutations);
                s[index] = Character.toLowerCase(s[index]);
                permutations.add(String.valueOf(s));
                generatePermutations(s, index + 1, length, permutations);
            }
        }
    }
}
