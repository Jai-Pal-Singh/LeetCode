package reverse_string;
//using Recursion
public class Solution2 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length-1;
        reverseString(s, start, end);
    }
    public void reverseString(char[] s, int start, int end) {
        char temp;
        if(start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
            reverseString(s, start, end);
        }
    }
}
