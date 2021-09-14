package reverse_only_letters;

// Given a string s, reverse the string according to the following rules:

// All the characters that are not English letters remain in the same position.
// All the English letters (lowercase or uppercase) should be reversed.
// Return s after reversing it.

 

// Example 1:

// Input: s = "ab-cd"
// Output: "dc-ba"
// Example 2:

// Input: s = "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"
// Example 3:

// Input: s = "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"
 

// Constraints:

// 1 <= s.length <= 100
// s consists of characters with ASCII values in the range [33, 122].
// s does not contain '\"' or '\\'.
//    Hide Hint #1  
// This problem is exactly like reversing a normal string except that there are certain characters that we have to simply skip. That should be easy enough to do if you know how to reverse a string using the two-pointer approach.

public class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length()-1;
        char [] input = s.toCharArray();
        while(left<right){
            if(!(((int)(input[left])>=65 && (int)(input[left])<=90) || ((int)(input[left])>=97 && (int)(input[left])<=122))){
                left++;
            }
            else if(!(((int)(input[right])>=65 && (int)(input[right])<=90) || ((int)(input[right])>=97 && (int)(input[right])<=122))){
                right--;
            }
            else{
                char temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                left++;
                right--;
            }
        }   
        return String.valueOf(input);
    }
}
