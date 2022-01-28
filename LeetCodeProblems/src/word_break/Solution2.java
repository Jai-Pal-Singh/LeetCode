package word_break;

import java.util.List;

public class Solution2 {
    Boolean[] mem ;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int len = s.length();
        if(len == 0 ){
            return true;
        }
        mem = new Boolean[len+1];
        
        
        return dfs(s, len, wordDict);
        
    }
    
    boolean dfs(String s, int i, List<String> wordDict){
        if(i == 0){
            return true;
        }
        
        if(mem[i] != null){
            return mem[i];
        }
        
        String str = s.substring(0,i);
        for(String word : wordDict){
            if(str.endsWith(word)){
                if(dfs(s, i-word.length(), wordDict)){
                    mem[i] = true; 
                    return true;
                }
            }
        }
        
        mem[i] = false;
        return false;
    }
}
