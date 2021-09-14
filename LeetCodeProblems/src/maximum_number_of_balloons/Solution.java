package maximum_number_of_balloons;

// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

// You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

// Example 1:



// Input: text = "nlaebolko"
// Output: 1
// Example 2:



// Input: text = "loonbalxballpoon"
// Output: 2
// Example 3:

// Input: text = "leetcode"
// Output: 0
 

// Constraints:

// 1 <= text.length <= 104
// text consists of lower case English letters only.
//    Hide Hint #1  
// Count the frequency of letters in the given string.
//    Hide Hint #2  
// Find the letter than can make the minimum number of instances of the word "balloon".

public class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] balloon = new char [] {'b', 'a', 'l', 'o', 'n'} ;
        int[] count = new int[5];
        for(int i = 0; i<text.length(); i++){
        if(contains(text.charAt(i), balloon)){
                count[indexOf(text.charAt(i), balloon)]++;
            }
        }
        int maxNumberOfBalloons = Integer.MAX_VALUE;
        for(int i = 0; i < count.length; i++){
            int freq = 0;
            if(i==indexOf('l', balloon) || i==indexOf('o', balloon)){
                freq = count[i]/2;
            }
            else{
                freq = count[i];
            }
            maxNumberOfBalloons = Math.min(maxNumberOfBalloons, freq);
        }
        return maxNumberOfBalloons;
    }

    private boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(char c, char[] array) {
        for (int i = 0; i<array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
