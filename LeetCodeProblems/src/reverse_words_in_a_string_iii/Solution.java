package reverse_words_in_a_string_iii;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String reverseWords(String s) {
        String[] splited = s.split("\\s+");
        return Arrays.stream(splited).map(str -> reverseString(str.toCharArray())).collect(Collectors.joining(" "));
    }
    
    public String reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        char temp;
        while(start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }

        return new String(s);
    }
}
