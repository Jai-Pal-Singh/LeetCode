package word_break_ii;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        List<String> ans = new ArrayList<>(); 
        if(len == 0 ){
            return ans;
        }  
        dfs(s, len, wordDict, ans, new Stack<>());
        return ans;
    }
    
    @SuppressWarnings("unchecked")
    private void dfs(String s, int i, List<String> wordDict, List<String> ans, Stack<String> text){
        if(i == 0){
            Stack<String> copy = (Stack<String>) text.clone();
            StringBuilder builder = new StringBuilder(); 
            while (!copy.empty()) {
                  builder.append(copy.pop()).append(" ");
            }
            ans.add(builder.toString().trim());
        }       
        String str = s.substring(0,i);
        for(String word : wordDict){
            if(str.endsWith(word)){
                text.push(word);
                dfs(s, i-word.length(), wordDict, ans, text);
                text.pop();
            }
        } 
    }
}
