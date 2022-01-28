package wildcard_matching;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) return true;
        if(p.length()==0) return false;
        
        char[] str = s.toCharArray();
        char[] ptrn = p.toCharArray();
        
        //removing multiple * in pattern. E.g. -> a***b***c to a*b*c
        int ptrnLen = 0;
        boolean isFirst = true;
        for(int i = 0; i<ptrn.length; i++){
            if(ptrn[i] == '*'){
                if(isFirst){
                    ptrn[ptrnLen++] = ptrn[i];
                    isFirst = false;
                }
            }
            else{
                ptrn[ptrnLen++] = ptrn[i];
                isFirst = true;
            }
        }
        boolean[][] dp = new boolean[str.length+1][ptrnLen+1];
        if(ptrn[0]=='*'){
            dp[0][1] = true;
        }
        dp[0][0] = true;
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(ptrn[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if(str[i-1] == ptrn[j-1] || ptrn[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[str.length][ptrnLen];
    }
}
