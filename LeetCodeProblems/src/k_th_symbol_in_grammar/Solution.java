package k_th_symbol_in_grammar;

// We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

// For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
// Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

// Example 1:

// Input: n = 1, k = 1
// Output: 0
// Explanation: row 1: 0
// Example 2:

// Input: n = 2, k = 1
// Output: 0
// Explanation:
// row 1: 0
// row 2: 01
// Example 3:

// Input: n = 2, k = 2
// Output: 1
// Explanation:
// row 1: 0
// row 2: 01
// Example 4:

// Input: n = 3, k = 1
// Output: 0
// Explanation:
// row 1: 0
// row 2: 01
// row 3: 0110
 

// Constraints:

// 1 <= n <= 30
// 1 <= k <= 2n - 1
//    Hide Hint #1  
// Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?

public class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;
        String ans = kthGrammar("0", n-1);
        // System.out.println("Returned ans : " + ans);
        // return (int) ans.charAt((k+1)%ans.length());
        return Character.getNumericValue(ans.charAt(k-1));
    }
    
    private String kthGrammar(String str, int n) {
        if(n==0) return str;
        char[] s = str.toCharArray();
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            if(s[i] == '0'){
                newStr.append("01");
            }
            else{
                newStr.append("10");
            }
        }
        // System.out.println("Generated string : " + newStr.toString() + " for n : " + n);
        return kthGrammar(newStr.toString(), n-1);
    }
}
