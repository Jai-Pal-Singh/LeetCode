package add_digits;

/**
 * 
Approach 1: Mathematical: Digital Root
Formula for the Digital Root

There is a known formula to compute a digital root in a decimal numeral system

dr_{10}(n) = 0, \qquad \text{if } n = 0dr 
10
​
 (n)=0,if n=0

dr_{10}(n) = 9, \qquad \text{if } n = 9 kdr 
10
​
 (n)=9,if n=9k

dr_{10}(n) = n \mod 9, \qquad \text{if } n \ne 9 kdr 
10
​
 (n)=nmod9,if n 

​
 =9k

How to derive it? Probably, you already know the following proof from school, where it was used for a divisibility by 9: "The original number is divisible by 9 if and only if the sum of its digits is divisible by 9". Let's revise it briefly.

The input number could be presented in a standard way, where d_0, d_1, .. d_kd 
0
​
 ,d 
1
​
 ,..d 
k
​
  are digits of n:

n = d_0 + d_1 \cdot 10^1 + d_2 \cdot 10^2 + ... + d_k \cdot 10^kn=d 
0
​
 +d 
1
​
 ⋅10 
1
 +d 
2
​
 ⋅10 
2
 +...+d 
k
​
 ⋅10 
k
 

One could expand each power of ten, using the following:

10 = 9 \cdot 1 + 1 \\ 100 = 99 + 1 = 9 \cdot 11 + 1 \\ 1000 = 999 + 1 = 9 \cdot 111 + 1 \\ ... \\ 10^k = 1underbrace{00..0}\text{k times} = underbrace{99..9}\text{k times} + 1 = 9 \cdot underbrace{11..1}\text{k times} + 110=9⋅1+1
100=99+1=9⋅11+1
1000=999+1=9⋅111+1
...
10 
k
 =1 
k times
00..0
​
 
​
 = 
k times
99..9
​
 
​
 +1=9⋅ 
k times
11..1
​
 
​
 +1

That results in

n = d_0 + d_1 \cdot (9 \cdot 1 + 1) + d_2 \cdot(9 \cdot 11 + 1) + ... + d_k \cdot (9 \cdot underbrace{11..1}\text{k times} + 1)n=d 
0
​
 +d 
1
​
 ⋅(9⋅1+1)+d 
2
​
 ⋅(9⋅11+1)+...+d 
k
​
 ⋅(9⋅ 
k times
11..1
​
 
​
 +1)

and could be simplified as

n = (d_0 + d_1 + d_2 + ... + d_k) + 9 \cdot (d_1 \cdot 1 + d_2 \cdot 11 + ... + d_k \cdot underbrace{11..1}\text{k times})n=(d 
0
​
 +d 
1
​
 +d 
2
​
 +...+d 
k
​
 )+9⋅(d 
1
​
 ⋅1+d 
2
​
 ⋅11+...+d 
k
​
 ⋅ 
k times
11..1
​
 
​
 )

The last step is to take the modulo from both sides:

n \mod 9 = (d_0 + d_1 + d_2 + ... + d_k) \mod 9nmod9=(d 
0
​
 +d 
1
​
 +d 
2
​
 +...+d 
k
​
 )mod9

and to consider separately three cases: the sum of digits is 0, the sum of digits is divisible by 9, and the sum of digits is not divisible by nine:

dr_{10}(n) = 0, \qquad \text{if } n = 0dr 
10
​
 (n)=0,if n=0

dr_{10}(n) = 9, \qquad \text{if } n = 9 kdr 
10
​
 (n)=9,if n=9k

dr_{10}(n) = n \mod 9, \qquad \text{if } n \ne 9 kdr 
10
​
 (n)=nmod9,if n 

​
 =9k

Implementation

The straightforward implementation is

Complexity Analysis

Time Complexity: \mathcal{O}(1)O(1).

Space Complexity: O(1)O(1).

@Link: https://leetcode.com/problems/add-digits/solution/

 */


public class Solution2 {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
