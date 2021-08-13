package longest_substring_without_repeating_characters;


// Given a string s, find the length of the longest substring without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Example 4:

// Input: s = ""
// Output: 0
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] map = new int[256];
       int maxCount = 0;
       for(int i = 0, j=0; i<s.length(); i++){
           char c= s.charAt(i);
           ++map[c];
           while(map[c] > 1){
               --map[s.charAt(j++)];
           }
           maxCount = Math.max(maxCount, i-j+1);
       }
        return maxCount;
    }
}
