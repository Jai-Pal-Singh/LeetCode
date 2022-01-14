package minimum_remove_to_make_valid_parentheses;

import java.util.Stack;

/* 
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> openBracePostion = new Stack<>();
        for(int i =0 ; i<result.length(); ) {
        	if(result.charAt(i) == '(') {
        		openBracePostion.push(i);
        		i++;
        	}
        	else if(result.charAt(i) == ')') {
        		if(!openBracePostion.isEmpty()) {
        			openBracePostion.pop();
        			i++;
        		}
        		else {
        			result.deleteCharAt(i);
        		}
        	}
        	else {
        		i++;
        	}
        }
        while(!openBracePostion.isEmpty()) {
        	result.deleteCharAt(openBracePostion.pop());
        }
		return result.toString();   
    }
}
