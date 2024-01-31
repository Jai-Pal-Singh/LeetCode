package letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
    }
}


public class Solution2 {
	public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] lookup = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		getCombinations(digits, lookup, ans, "");
		return ans;
    }

    public void getCombinations(String digits, String[] lookup, LinkedList<String> ans, String temp){
        if(temp.length() == digits.length()){
            ans.add(temp);
            return;
        }
        int n = temp.length();
        for(char c : lookup[digits.charAt(n)-'0'].toCharArray()){
            getCombinations(digits, lookup, ans, temp+c);
        }
    }
}
