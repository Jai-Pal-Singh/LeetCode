package word_pattern;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false
// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false
 

// Constraints:

// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lowercase English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        Set<String> words = new HashSet<>();
        
        String[] str = s.split(" ");
        if(pattern.length()!=str.length){
            return false;
        }
        for(int i = 0; i<str.length; i++){
            if(!Objects.nonNull(map[pattern.charAt(i)-'a']) && !words.contains(str[i])){
                words.add(str[i]);
                map[pattern.charAt(i)-'a'] = str[i];
            }
            else if(Objects.nonNull(map[pattern.charAt(i)-'a']) && words.contains(str[i]) && str[i].equals(map[pattern.charAt(i)-'a'])){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
