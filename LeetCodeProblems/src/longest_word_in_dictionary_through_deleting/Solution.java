package longest_word_in_dictionary_through_deleting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hp
 * @implNote Given a string and a string dictionary, find the longest string in
 *           the dictionary that can be formed by deleting some characters of
 *           the given string. If there are more than one possible results,
 *           return the longest word with the smallest lexicographical order. If
 *           there is no possible result, return the empty string.
 * 
 *           Example 1: Input: s = "abpcplea", d =
 *           ["ale","apple","monkey","plea"]
 *           Output: "apple" 
 *           
 *           Example 2: Input: s = "abpcplea", d = ["a","b","c"] * 
 *           Output: "a" 
 *           Note: All the strings in the input will only contain
 *           lower-case letters. The size of the dictionary won't exceed 1,000.
 *           The length of all the strings in the input won't exceed 1,000.
 *
 */
public class Solution {

	public String findLongestWord(String s, List < String > d) {
        Collections.sort(d, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str: d) {
            if (isSubsequence(str, s))
                return str;
        }
        return "";
    }
	
	public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    
//	public String findLongestWord(String s, List<String> d) {
//		String longestWord = "";
//		int longestWordLength = 0;
//		Collections.sort(d);
////		d.stream().forEach(System.out::println);
//		for(String word : d){
//			int currentLength = lcs(s.toCharArray(), word.toCharArray(), s.length(), word.length());
//			System.out.println("Word: "+word+", \nlength: "+currentLength);
//			if(currentLength > longestWordLength && currentLength==word.length()) {
//				longestWord = word;
//				longestWordLength = currentLength;
//			}
//		};
//		return longestWord;
//	}
//	
//	private int lcs( char[] X, char[] Y, int m, int n ) 
//	  { 
//	    int L[][] = new int[m+1][n+1]; 
//	  
//	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
//	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
//	    for (int i=0; i<=m; i++) 
//	    { 
//	      for (int j=0; j<=n; j++) 
//	      { 
//	        if (i == 0 || j == 0) 
//	            L[i][j] = 0; 
//	        else if (X[i-1] == Y[j-1]) 
//	            L[i][j] = L[i-1][j-1] + 1; 
//	        else
//	            L[i][j] = max(L[i-1][j], L[i][j-1]); 
//	      } 
//	    } 
//	  return L[m][n]; 
//	  }
//	
//	private int max(int a, int b) 
//	  { 
//	    return (a > b)? a : b; 
//	  }
}
