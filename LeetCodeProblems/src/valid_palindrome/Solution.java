package valid_palindrome;

// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.

public class Solution {
     public boolean isPalindrome(String s) {
         int head = 0, tail = s.length()-1;
         while(head < tail){
             char front = s.charAt(head);
             char rear = s.charAt(tail);
             if(!Character.isLetterOrDigit(front)){
                 head++;
             }
             else if(!Character.isLetterOrDigit(rear)){
                 tail--;
             }
             else{
                 if(Character.toLowerCase(front) != Character.toLowerCase(rear)) return false;
                 head++;
                 tail--;
             }
         }
        return true;
    }    
}
