package delete_operation_for_two_strings;

import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 */
public class Solution {
    int[][] mat;
    
    public int minDistance(String word1, String word2) {
        int t1Len = word1.length();
        int t2Len = word2.length();
        mat = new int[t1Len + 1][t2Len + 1];
        for (int i = 0; i < t1Len + 1; i++) {
            Arrays.fill(mat[i], -1);
        }
        int lcs = longestCommonSubsequence(word1, word2, t1Len, t2Len);
        return t1Len + t2Len - (2*lcs);
    }
    
    public int longestCommonSubsequence(String s, String r, int sLen, int rLen) {
        if (sLen == 0 || rLen == 0) {
            return 0;
        }

        if (mat[sLen][rLen] != -1) {
            return mat[sLen][rLen];
        }

        if (s.charAt(sLen - 1) == r.charAt(rLen - 1)) {
            mat[sLen][rLen] = longestCommonSubsequence(s, r, sLen - 1, rLen - 1) + 1;
        } else {
            mat[sLen][rLen] = Math.max(longestCommonSubsequence(s, r, sLen - 1, rLen),
                    longestCommonSubsequence(s, r, sLen, rLen - 1));
        }
        return mat[sLen][rLen];
    }
}
