package decode_string;

import java.util.Deque;
import java.util.LinkedList;
/* 
Given an encoded string,return its decoded string.

The encoding rule is:k[encoded_string],where the encoded_string inside the square brackets is being repeated exactly k times.Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid;No extra white spaces,square brackets are well-formed,etc.

Furthermore,you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,k.For example,there won'tbe input like 3 a or 2[4].

Example 1:

Input:s="3[a]2[bc]"Output:"aaabcbc"Example 2:

Input:s="3[a2[c]]"Output:"accaccacc"Example 3:

Input:s="2[abc]3[cd]ef"Output:"abcabccdcdcdef"Example 4:

Input:s="abc3[cd]xyz"Output:"abccdcdcdxyz"

Constraints:

1<=s.length<=30 s consists of lowercase English letters,digits,and square brackets'[]'.s is guaranteed to be a valid input.All the integers in s are in the range[1,300].
 */
class Solution{
    public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray())
            queue.offer(c);
        return helper(queue);
    }

    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++)
                    sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}