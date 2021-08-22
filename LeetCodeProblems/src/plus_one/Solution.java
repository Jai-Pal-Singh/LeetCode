package plus_one;

// Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

 

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Example 3:

// Input: digits = [0]
// Output: [1]
 

// Constraints:

// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9

public class Solution {
    public int[] plusOne(int[] digits) {
        int end = digits.length-1;
        if(digits[end] == 9){
            if(countNineOccurenceFromLast(digits) == end+1){
                int [] newDigits = new int[end+2];
                newDigits[0] = 1;
                return newDigits;
            }
            else{
                while(digits[end] == 9){
                    digits[end] = 0;
                    end--;
                }
                digits[end] +=1;
                return digits;
            }
        }
        else{
            digits[end] += 1;
            return digits; 
        }
    }

    private int countNineOccurenceFromLast(int[] digits){
        int count = 0;
        for(int i = digits.length -1; i >=0; i--){
            if(digits[i] != 9) return count;
            count++;
        }
        return count;
    }
}
