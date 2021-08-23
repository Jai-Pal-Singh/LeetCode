package first_unique_character_in_a_string;

import java.util.HashMap;

// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1
 

// Constraints:

// 1 <= s.length <= 105
// s consists of only lowercase English letters.

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> occurenceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            occurenceMap.put(c, occurenceMap.containsKey(c) ? occurenceMap.get(c) + 1 : 1 );
        }

        for (int i = 0; i < s.length(); i++) {
            if(occurenceMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
