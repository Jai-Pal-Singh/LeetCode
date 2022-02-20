package fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 

Constraints:

1 <= n <= 104
 */

 
/**
 * Approach 2: String Concatenation
Intuition

This approach won't reduce the asymptotic complexity, but proves to be a neater solution when FizzBuzz comes with a twist. What if FizzBuzz is now FizzBuzzJazz i.e.

3 ---> "Fizz" , 5 ---> "Buzz", 7 ---> "Jazz"
If you try to solve this with the previous approach the program would have too many conditions to check:

Divisible by 3
Divisible by 5
Divisible by 7
Divisible by 3 and 5
Divisible by 3 and 7
Divisible by 7 and 3
Divisible by 3 and 5 and 7
Not divisible by 3 or 5 or 7.
This way if the FizzBuzz mappings increase, the conditions would grow exponentially in your program.

Algorithm

Instead of checking for every combination of these conditions, check for divisibility by given numbers i.e. 3, 5 as given in the problem. If the number is divisible, concatenate the corresponding string mapping Fizz or Buzz to the current answer string.

For eg. If we are checking for the number 15, the steps would be:

Condition 1: 15 % 3 == 0 , num_ans_str = "Fizz"
Condition 2: 15 % 5 == 0 , num_ans_str += "Buzz"
=> num_ans_str = "FizzBuzz"
So for FizzBuzz we just check for two conditions instead of three conditions as in the first approach.

Similarly, for FizzBuzzJazz now we would just have three conditions to check for divisibility.

Complexity Analysis

Time Complexity: O(N)
Space Complexity: O(1)
 */

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
          boolean divisibleBy3 = (num % 3 == 0);
          boolean divisibleBy5 = (num % 5 == 0);
          String numAnsStr = "";
          if (divisibleBy3) {
            // Divides by 3, add Fizz
            numAnsStr += "Fizz";
          }
          if (divisibleBy5) {
            // Divides by 5, add Buzz
            numAnsStr += "Buzz";
          }
          if (numAnsStr.equals("")) {
            // Not divisible by 3 or 5, add the number
            numAnsStr += Integer.toString(num);
          }
          // Append the current answer str to the ans list
          ans.add(numAnsStr);
        }
        return ans;
    }
}
