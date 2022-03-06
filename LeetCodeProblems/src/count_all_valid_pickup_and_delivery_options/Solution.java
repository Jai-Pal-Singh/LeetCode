package count_all_valid_pickup_and_delivery_options;

/**
 * Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90
 

Constraints:

1 <= n <= 500
 */


 
/**
 * Approach 3: Permutations (Math)
Intuition

Let's assume we want to place 4 different objects (A, B, C, D respectively) in some order in a row, what are all the possible ways to do it?
Now how can we approach this problem?

We can say we have 4 empty positions and at each position, we have to place one object.
At the 1st position, we can place any one of the 4 objects so we have 4 choices here.
At the 2nd position, we can only place any one of 3 objects because one object is already placed at the 1st position.
At the 3rd position, we can place any one of the remaining 2 objects (2 objects are already placed).
At the 4th position, we can place the remaining 1 object (3 objects are already placed).

Hence, total number of ways to place 44 different objects = 4 \cdot 3 \cdot 2 \cdot 1 = 4!4⋅3⋅2⋅1=4!.

rearrange

A permutation is a mathematical calculation of the number of ways a particular set can be arranged, where the order of the arrangement matters.

Now, the given problem can be changed to a similar permutations problem.

We have NN orders each with a pickup and delivery, let's denote P_i = Pickup \space of \space i^{th} \space order,P 
i
​
 =Pickup of i 
th
  order, and D_i = Delivery \space of \space i^{th} \space orderD 
i
​
 =Delivery of i 
th
  order.

We have 2N2N empty positions and we need to count all ways to place all P_iP 
i
​
  and D_iD 
i
​
  such that all D_iD 
i
​
  is placed after P_iP 
i
​
 .

So, we first place all the NN pickups in some random order as we don't have any constraints on placing pickups.
As we saw with an example above, to place NN different objects, we have N!N! ways. So NN pickups can be placed in N!N! ways.

Now, let's take an example of 4 orders.

pickups

Now we start placing all the deliveries one by one.
The last pickup was P3, hence for D3 we have only one place i.e. after P3.

del-1

Now, the second last pickup was P1, so we have three places to place the delivery D1.

del-2

Similarly, for D4 we have five places and for D2 we have seven places.

del-4

So, the number of ways to place all deliveries is 1 \cdot 3 \cdot 5 \cdot 71⋅3⋅5⋅7.

Thus, we can come to the formula that, to place NN pickups we have N!N! ways,
and to place the NN deliveries we have 1 \cdot 3 \cdot 5 \space \cdot .... \cdot \space (2N-1)1⋅3⋅5 ⋅....⋅ (2N−1) ways.

So, total ways to arrange all pickups and deliveries are, N! * \prod_{i=1}^{N} (2 * i - 1)N!∗∏ 
i=1
N
​
 (2∗i−1).

Algorithm

Initialize some variables:

MOD as 10^{9} + 710 
9
 +7 to prevent integer overflow (as stated in the problem description).
ans, to store the final result.
Calculate the number of ways to arrange pickups and deliveries, i.e. N!N! and \prod_{i=1}^{N} (2 * i - 1)∏ 
i=1
N
​
 (2∗i−1) and multiply them to calculate total ways to arrange pickups and deliveries for N orders with handling the overflow.

Return the final result ans.

Implementation


Complexity Analysis

If NN is the number of the orders given.

Time complexity: O(N)O(N).

To calcualte N!N! and \prod_{i=1}^{N} (2 * i - 1)∏ 
i=1
N
​
 (2∗i−1) we need to iterate over NN elements.

Space complexity: O(1)O(1).

We have used only constant space to store the result.
 */
public class Solution {

    public int countOrders(int n) {
        long ans = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; ++i) {
            // Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = ans * i;
            // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = ans * (2 * i - 1);
            ans %= MOD;
        }
        
        return (int)ans;
    }
}