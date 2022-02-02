package find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] lookup = new int[26];
        for (Character c : p.toCharArray()) {
            lookup[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        int diff = p.length();
        char temp;
        for (end = 0; end < p.length(); end++) {
            temp = s.charAt(end);
            lookup[temp - 'a']--;
            if (lookup[temp - 'a'] >= 0) {
                diff--;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        while (end < s.length()) {
            temp = s.charAt(start);
            if (lookup[temp - 'a'] >= 0) {
                diff++;
            }
            lookup[temp - 'a']++;
            start++;
            temp = s.charAt(end);
            lookup[temp - 'a']--;
            if (lookup[temp - 'a'] >= 0) {
                diff--;
            }
            if (diff == 0) {
                ans.add(start);
            }
            end++;
        }
        return ans;
    }
}
