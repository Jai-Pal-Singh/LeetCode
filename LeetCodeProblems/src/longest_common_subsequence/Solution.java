package longest_common_subsequence;

import java.util.Arrays;

/* 
Given two strings text1 and text2,return the length of their longest common subsequence.If there is no common subsequence,return 0.

A subsequence of a string is a new string generated from the original string with some characters(can be none)deleted without changing the relative order of the remaining characters.

For example,"ace"is a subsequence of"abcde".A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input:text1="abcde",text2="ace"Output:3 Explanation:The longest common subsequence is"ace"and its length is 3. Example 2:

Input:text1="abc",text2="abc"Output:3 Explanation:The longest common subsequence is"abc"and its length is 3. Example 3:

Input:text1="abc",text2="def"Output:0 Explanation:There is no such common subsequence,so the result is 0.

Constraints:

1<=text1.length,text2.length<=1000 text1 and text2 consist of only lowercase English characters.
 */
public class Solution {
    int[][] mat;

    public int longestCommonSubsequence(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();
        mat = new int[t1Len + 1][t2Len + 1];
        for (int i = 0; i < t1Len + 1; i++) {
            Arrays.fill(mat[i], -1);
        }
        return longestCommonSubsequence(text1, text2, t1Len, t2Len);
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
