package longest_valid_parentheses;

/**
 * Another Efficient Approach can solve the problem in O(n) time. The idea is to maintain an array that stores the length of the longest valid substring ending at that index. We iterate through the array and return the maximum value.

 

1) Create an array longest of length n (size of the input
   string) initialized to zero.
   The array will store the length of the longest valid 
   substring ending at that index.

2) Initialize result as 0.

3) Iterate through the string from second character
   a) If the character is '(' set longest[i]=0 as no 
      valid sub-string will end with '('.
   b) Else
      i) if s[i-1] = '('
            set longest[i] = longest[i-2] + 2
      ii) else
            set longest[i] = longest[i-1] + 2 + 
            longest[i-longest[i-1]-2]

4) In each iteration update result as the maximum of 
   result and longest[i]

5) Return result.

@Link: https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
@Link: https://leetcode.com/problems/longest-valid-parentheses/solution/
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1)
            return 0;
        // Initialize curMax to zero
        int curMax = 0;
        int[] longest = new int[s.length()];

        // Iterate over the String starting from second index
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2
                        + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                curMax = Math.max(longest[i], curMax);
            }
        }
        return curMax;
    }
}
