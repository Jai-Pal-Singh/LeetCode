package permutation_in_string;

import java.util.HashMap;
import java.util.Map;

import helper.BasicFunctions;

/* 
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        Map<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < s1Len; i++) {
            Character c = s1.charAt(i);
            s1Map.put(c, s1Map.containsKey(c) ? s1Map.get(c) + 1 : 1);
        }

        for (int i = 0; i < s2Len; i++) {
            Character c = s2.charAt(i);
            if (s1Map.containsKey(c)) {
                int currLen = 0;
                int j = i;
                Map<Character, Integer> s1MapCopy = new HashMap<>(s1Map);
                while (j < s2Len && s1MapCopy.containsKey(s2.charAt(j)) && 
                (s1MapCopy.get(s2.charAt(j)) > 0)) {
                    currLen++;
                    s1MapCopy.put(s2.charAt(j), s1MapCopy.get(s2.charAt(j)) - 1);
                    j++;
                }
                if (currLen == s1Len) {
                    BasicFunctions.print(s1Map);
                    return true;
                }
            }
        }
        return false;
    }
}
