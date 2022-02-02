package longest_substring_without_repeating_characters;

import java.util.HashMap;

/**
 * Approach: In this approach, we will make a map that will take care of counting the elements and maintaining the frequency of each and every element as a unity by taking the latest index of every element.
 * Time Complexity: O( N )

Space Complexity: O(N) where N represents the size of HashSet where we are storing our elements
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) 
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            mpp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
