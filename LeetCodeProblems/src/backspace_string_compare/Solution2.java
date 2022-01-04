package backspace_string_compare;

import java.util.Stack;
/* 
Approach #1: Build String [Accepted]
Intuition

Let's individually build the result of each string (build(S) and build(T)), then compare if they are equal.

Algorithm

To build the result of a string build(S), we'll use a stack based approach, simulating the result of each keystroke.


Complexity Analysis

Time Complexity: O(M + N)O(M+N), where M, NM,N are the lengths of S and T respectively.

Space Complexity: O(M + N)O(M+N).
 */

public class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
