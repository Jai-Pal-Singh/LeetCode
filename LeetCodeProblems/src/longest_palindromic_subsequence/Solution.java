package longest_palindromic_subsequence;
/* 
Given a string s,find the longest palindromic subsequence'slength in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input:s="bbbab"Output:4 Explanation:One possible longest palindromic subsequence is"bbbb".Example 2:

Input:s="cbbd"Output:2 Explanation:One possible longest palindromic subsequence is"bb".

Constraints:

1<=s.length<=1000 s consists only of lowercase English letters.
 */

 // This is a recursive solution. It make exceed time limit.
public class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder r = new StringBuilder(s);
        return longestCommonSubsequence(s, r.reverse().toString(), s.length(), r.length());
    }

    public int longestCommonSubsequence(String s, String r, int sLen, int rLen) {
        if (sLen == 0 || rLen == 0) {
            return 0;
        }
        if (s.charAt(sLen - 1) == r.charAt(rLen - 1)) {
            return longestCommonSubsequence(s, r, sLen - 1, rLen - 1) + 1;
        } else {
            return Math.max(longestCommonSubsequence(s, r, sLen - 1, rLen),
                    longestCommonSubsequence(s, r, sLen, rLen - 1));
        }
    }
}
