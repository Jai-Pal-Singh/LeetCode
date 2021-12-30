package smallest_integer_divisible_by_k;
/* 
Given a positive integer k,you need to find the length of the smallest positive integer n such that n is divisible by k,and n only contains the digit 1.

Return the length of n.If there is no such n,return-1.

Note:n may not fit in a 64-bit signed integer.

Example 1:

Input:k=1 Output:1 Explanation:The smallest answer is n=1,which has length 1. Example 2:

Input:k=2 Output:-1 Explanation:There is no such positive integer n divisible by 2. Example 3:

Input:k=3 Output:3 Explanation:The smallest answer is n=111,which has length 3.

Constraints:

1<=k<=105
 */

 /*
 It's an interesting problem that requires a little observation and insight. It's recommended to try a few numbers to find out some regular patterns. Below, we will discuss a simple approach to solve this problem.
 
 Approach 1: Checking Loop
 Intuition
 
 We need to do two things:
 
 check if the required number N exists.
 find out length(N).
 The second one is easy: we only need to keep multiplying N by 10 and adding 1 until N%K==0. However, since N might overflow, we need to use the remainder. The pseudo-code is as below:
 
 remainder = 1
 length_N = 1
 
 while remainder%K != 0
    N = remainder*10 + 1
    remainder = N%K
    length_N += 1
 
 return length_N
 Since the remainder and N have the same remainder of K, it OK to use remainder instead of N.
 
 Now, the only problem is how to check whether the required number N exists.
 
 Notice that if N does not exist, this while-loop will continue endlessly. However, the possible values of remainder are limited -- ranging from 0 to K-1. Therefore, if the while-loop continues forever, the remainder repeats. Also, if remainder repeats, then it gets into a loop. Hence, the while-loop is endless if and only if the remainder repeats.
 
 In this case, we can check if the remainder repeats to check if the while-loop is endless:
 
 remainder = 1
 length_N = 1
 
 seen_remainders = set()
 
 while remainder%K != 0
    N = remainder*10 + 1
    remainder = N%K
    length_N += 1
 
    if remainder in seen_remainders
        return -1
    else
        seen_remainders.add(remainder)
 
 return length_N
 Now we have an algorithm that can solve the problem.
 
 Furthermore, we can improve this algorithm with Pigeonhole Principle. Recall that the number of possible values of remainder (ranging from 0 to K-1) is limited, and in fact, the number is K. As a result, if the while-loop continues more than K times, and haven't stopped, then we can conclude that remainder repeats -- you can not have more than K different remainder.
 
 Hence, if N exists, the while-loop must return length_N in the first K loops. Otherwise, it goes into an infinite loop.
 
 Therefore, we can just run the while-loop K times, and return -1 if not stopped.
 
 Algorithm
 
 We just run the while-loop K times, check if the remainder is 0, and return -1 if not stopped.
 
 Note: After reading the Algorithm part, it is recommended to try writing the code on your own before reading the solution code.
 
 
 There are a few interesting points worth pointing out in the code above:
 
 We initialize remainder to 0, not 1, to keep code consistency because in the first loop the remainder changes to 1. You can also initialize it as 1, but it requires a little change in code.
 We only run the loop K times at most, not K+1. This is because if it does not stop in the previous K loop, it will continue the K+1-th iteration, which must have repeated remainder. Therefore, it is not necessary to check the K+1-th iteration.
 Also, note that 111...111 can never be divided by 2 or 5 because its last digit is never an even number or 5. You can just return -1 if you find that 2 or 5 is a factor of K.
 
 Complexity Analysis
 
 Time Complexity : \mathcal{O}(K)O(K) since we at most run the loop \mathcal{O}(K)O(K) times.
 
 Space Complexity : \mathcal{O}(1)O(1) since we only use three ints: K, remainder, and length_N.
 */
public class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for (int length_N = 1; length_N <= k; length_N++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}
