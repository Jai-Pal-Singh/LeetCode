package longest_palindromic_subsequence;

import java.util.Arrays;

public class Solution2 {
    int[][] mat;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        mat = new int[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            Arrays.fill(mat[i], -1);
        }
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString(), len, len);
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
        } 
        else {
            mat[sLen][rLen] = Math.max(longestCommonSubsequence(s, r, sLen - 1, rLen),
                    longestCommonSubsequence(s, r, sLen, rLen - 1));
        }
        return mat[sLen][rLen];
    }
}
