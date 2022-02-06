package longest_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */

 /**
  * An Efficient Solution can solve this problem in O(n) time. The idea is to store indexes of previous starting brackets in a stack. The first element of the stack is a special element that provides index before the beginning of valid substring (base for next valid string). 

1) Create an empty stack and push -1 to it. 
   The first element of the stack is used 
   to provide a base for the next valid string. 

2) Initialize result as 0.

3) If the character is '(' i.e. str[i] == '('), 
   push index'i' to the stack. 
   
2) Else (if the character is ')')
   a) Pop an item from the stack (Most of the 
      time an opening bracket)
   b) If the stack is not empty, then find the
      length of current valid substring by taking 
      the difference between the current index and
      top of the stack. If current length is more 
      than the result, then update the result.
   c) If the stack is empty, push the current index
      as a base for the next valid substring.

3) Return result.

@link : https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
  */
  
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    count = Math.max(count, i - stack.peek()); 
                }
                else{
                    stack.push(i);
                }
            }
        }
        return count;
    }
}
