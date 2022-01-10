package multiply_strings;

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

// Example 1:

// Input: num1 = "2", num2 = "3"
// Output: "6"
// Example 2:

// Input: num1 = "123", num2 = "456"
// Output: "56088"
//  
// 
// Constraints:
// // 
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.
// 
// 
// 
// Approach 3: Sum the products from all pairs of digits
// Intuition
// 
// As we have seen in the previous approaches, when we multiply two digits, one from the first number and one from the second number, then their product will have some zeros appended at the end. The number of zeros depends on the place of each digit, and (as demonstrated in the image below) when the result is added to the answer, the trailing zeros do not affect the answer (because any number plus zero is itself). So it is not necessary for us to append zeros at the end of each result before adding the result to the final answer. Instead, we can directly add the multiplication result at the place where the least significant digit will shift to after to appending some zeros.
// 
// As an example, when we multiply two tens place digits, two zeros are appended at the end of the multiplication result, and the result will be added at the hundreds place in the final answer. One more example for clarity, if we multiplied a digit in the thousands place (3 trailing zeros) by a digit in the hundreds place (2 trailing zeros), the product will have 5 trailing zeros (the sum of trailing zeros of each digit) so the result will only affect the hundred thousands place and the millions place in the final answer.
// 
// image
// 
// 
// In the previous solution, including the extra zeros was quite costly. For instance, multiplyOneDigit stored these extra zeros for every intermediate result which required an additional O(N)O(N) space and time for each multiplication, where NN is the number of digits in num2. Furthermore, every time we called multiplyOneDigit we added the result to the current answer. This involved iterating over all M + NM+N digits in answer each time we added a new result to the current answer. So let's get a better idea of how we can solve this problem without iterating over all the extra zeros.
// 
// Take a moment to study the above example. Notice that we multiply each digit in num2 by each digit in num1 just like before. Each time we will get a 2-digit result with some zeros after it. Since we know how many zeros will follow the product of the two digits based on their places, we know which two places in answer to update. So, instead of updating all M + NM+N elements in answer for each of the NN digits in num2, we only need to update 22 digits in answer for each of the M \cdot NM⋅N pairs of digits. The above example highlights the two digits from each result that we will add to the answer and the below example shows precisely how this will be done.
// 
// Thus, for each pair of digits, we multiply them together to get a 2-digit result. The ones place of the result will be added at the correct position in answer (based on the place of each of the digits). The tens place of the result will be added to the next place in answer. This step is effectively the same as carrying the tens place digit in the previous approaches.
// 
// Note that the answer array will be reversed just like before. So when we multiply a digit in the i^{th}i 
// th
//   place of the first number by a digit in the j^{th}j 
// th
//   place of the second number, then the ones place of the result will add to the (i+j)^{th}(i+j) 
// th
//   place in the final answer and the tens place of the result (carry) will be added to the (i+j+1)^{th}(i+j+1) 
// th
//   place in the final answer.
// 
// Algorithm
// 
// Reverse both numbers.
// Initialize answer with N + MN+M zeros.
// For each digit at position i in secondNumber:
// For each digit at position j in firstNumber:
// Multiply the digit from secondNumber by the digit from firstNumber and add previously carried value to the multiplication result. The previously carried value can be found at position i + j in the answer.
// Take the remainder of multiplication with 10 to get the ones place digit of the multiplication result.
// Put the last digit at current position (position i + j) in answer.
// Divide the multiplication by 10 to get the new value for carry and add it to answer at the next position. Note, the next position is located at (i + j + 1).
// If the last digit in answer is zero, before reversing answer, we must pop the zero from answer. Otherwise, there would be a leading zero in the final answer.
// Reverse answer and return it.
// Current
// 6 / 20
// Implementation
// 
// 
// Complexity Analysis
// 
// Here NN and MM are the number of digits in num1 and num2 respectively.
// 
// Time complexity: O(M \cdot N)O(M⋅N).
// 
// During multiplication, we perform N operations for each of the M digits of the second number, so we need M \cdot NM⋅N time for it.
// 
// Space complexity: O(M + N)O(M+N).
// 
// The space used to store the output is not included in the space complexity. However, because strings are immutable in Python, Java, and Javascript, a temporary data structure, using O(M + N)O(M+N) space, is required to store the answer while it is updated.
// 
// On the other hand, in C++, strings are mutable, so we do not need a temporary data structure to store answer and can update answer directly. Thus, the C++ approach is a constant space solution.


public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);
        firstNumber.reverse();
        secondNumber.reverse();
        
        int N = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder(N);
        for (int i = 0; i < N; ++i) {
            answer.append(0);
        }
        
        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';
            
            // For each digit in secondNumber multiply the digit by all digits in firstNumber.
            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';
                
                // The number of zeros from multiplying to digits depends on the 
                // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
                int currentPos = place1 + place2;
                
                // The digit currently at position currentPos in the answer string
                // is carried over and summed with the current result.
                int carry = answer.charAt(currentPos) - '0';
                int multiplication = digit1 * digit2 + carry;
                
                // Set the ones place of the multiplication result.
                answer.setCharAt(currentPos, (char)(multiplication % 10 + '0'));
                
                // Carry the tens place of the multiplication result by 
                // adding it to the next position in the answer array.
                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPos + 1, (char)(value + '0'));
            }
        }
        
        // Pop excess 0 from the rear of answer.
        if (answer.charAt(answer.length() - 1) == '0') {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        return answer.reverse().toString();
    }
}
