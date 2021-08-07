package coin_change;

import java.util.Arrays;

/* 
Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class Solution {
    //optimized solution
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
          for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
              dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
          }
        }
        return dp[amount] > amount ? -1 : dp[amount];
      }
    // public int coinChange(int[] coins, int amount) {
    //     Arrays.sort(coins);
    //     int[][] minChange = new int[2][amount+1];

    //     if(amount == 0 ) return 0;
    //     if(amount < coins[0]) return -1;

    //     //initial setup for first row
    //     minChange[0][0] = 0;
    //     minChange[1][0] = 0;
    //     int count = 0;
        
    //     for(int i = 1; i<amount+1; i++){
    //         if(i % coins[0] == 0){
    //             count++;
    //             minChange[0][i] = count;
    //         }
    //         else{
    //             minChange[0][i] = -1;
    //         }
    //     }

    //     int row = 1;

    //     //build the rest of the solution array
    //     for(; row < coins.length; row++){
    //         for(int i = 1; i<amount+1; i++){
    //             if(coins[row]>i){
    //                 minChange[row % 2][i] = minChange[(row - 1) % 2][i];
    //             }
    //             else{
    //                 int topValue = minChange[(row - 1) % 2][i];
    //                 int leftValue = (((i-coins[row])>-1) && minChange[row%2][i-coins[row]] > -1) ? minChange[row%2][i-coins[row]] + 1: -1;
    //                 if(topValue == -1 && leftValue == -1){
    //                     minChange[row % 2][i] = -1;
    //                 }
    //                 else if(topValue == -1 || leftValue == -1){
    //                     minChange[row % 2][i] = (topValue == -1) ? leftValue : topValue;
    //                 }
    //                 else{
    //                     minChange[row % 2][i] = Math.min(topValue, leftValue);
    //                 }
    //             }
    //         }
    //     }
    //     printArray(minChange, row, amount+1);
    //     return minChange[(row-1)%2][amount];
    // }

    // private void printArray(int[][] arr, int row, int length){
    //     System.out.println("Array:");
    //     for(int i =0; i<2; i++){
    //         for(int j =0; j<length;j++){
    //             System.out.print(arr[row%2][j] + ", ");
    //         }
    //         System.out.println();
    //         row++;
    //     }
    // }
}
