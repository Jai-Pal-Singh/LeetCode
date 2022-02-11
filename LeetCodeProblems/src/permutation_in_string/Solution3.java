package permutation_in_string;

/**
 * Approach #5 Sliding Window [Accepted]:
Algorithm

Instead of generating the hashmap afresh for every window considered in s2s2, we can create the hashmap just once for the first window in s2s2. Then, later on when we slide the window, we know that we remove one preceding character and add a new succeeding character to the new window considered. Thus, we can update the hashmap by just updating the indices associated with those two characters only. Again, for every updated hashmap, we compare all the elements of the hashmap for equality to get the required result.

Complexity Analysis

Time complexity: O(l_1+26*(l_2-l_1))

Space complexity: O(1). Constant space is used.
 */
public class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
