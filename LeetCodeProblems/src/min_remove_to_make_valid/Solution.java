package min_remove_to_make_valid;

import java.util.Stack;

/**
 * @author hp
 * @implNote Given a string s of '(' , ')' and lowercase English characters.
 * 
 *           Your task is to remove the minimum number of parentheses ( '(' or
 *           ')', in any positions ) so that the resulting parentheses string is
 *           valid and return any valid string.
 * 
 *           Formally, a parentheses string is valid if and only if:
 * 
 *           It is the empty string, contains only lowercase characters, or It
 *           can be written as AB (A concatenated with B), where A and B are
 *           valid strings, or It can be written as (A), where A is a valid
 *           string.
 * @implSpec Constraints:
 * 
 *           1 <= s.length <= 10^5 s[i] is one of '(' , ')' and lowercase
 *           English letters.
 */
public class Solution {
	public String minRemoveToMakeValid(String s) {
//		System.out.println("entered with s = "+s);
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> openBracePostion = new Stack<>();
//        System.out.println("before for loop");
        for(int i =0 ; i<result.length(); ) {
        	if(result.charAt(i) == '(') {
        		openBracePostion.push(i);
//        		System.out.println("pushed in stack ( at position : " + i);
        		i++;
        	}
        	else if(result.charAt(i) == ')') {
        		if(!openBracePostion.isEmpty()) {
        			openBracePostion.pop();
//        			System.out.println("poped : " + openBracePostion.pop() + " , at i = " + i );
        			i++;
        		}
        		else {
        			result.deleteCharAt(i);
//        			System.out.println("deleted : " + result.deleteCharAt(i) + " , at i = " + i );
        		}
        	}
        	else {
        		i++;
        	}
        }
        while(!openBracePostion.isEmpty()) {
        	result.deleteCharAt(openBracePostion.pop());
        }
//        System.out.println("result : " + result);
		return result.toString();
    }
}
