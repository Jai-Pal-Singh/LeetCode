package backspace_string_compare;
/* 
Given two strings s and t,return true if they are equal when both are typed into empty text editors.'#'means a backspace character.

Note that after backspacing an empty text,the text will continue empty.

Example 1:

Input:s="ab#c",t="ad#c"Output:true Explanation:Both s and t become"ac".Example 2:

Input:s="ab##",t="c#d#"Output:true Explanation:Both s and t become"".Example 3:

Input:s="a#c",t="b"Output:false Explanation:s becomes"c"while t becomes"b".

Constraints:

1<=s.length,t.length<=200 s and t only contain lowercase letters and'#'characters.

Follow up:Can you solve it in O(n)time and O(1)space?
 */

//  Approach #2: Two Pointer [Accepted]
// Intuition

// When writing a character,it may or may not be part of the final string depending on how many backspace keystrokes occur in the future.

// If instead we iterate through the string in reverse,then we will know how many backspace characters we have seen,and therefore whether the result includes our character.

// Algorithm

// Iterate through the string in reverse.If we see a backspace character,the next non-backspace character is skipped.If a character isn'tskipped,it is part of the final answer.

// See the comments in the code for more details.

// Complexity Analysis

// Time Complexity:O(M+N)O(M+N),where M,NM,N are the lengths of S and T respectively.

// Space Complexity:O(1)O(1).

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
