package coin_change;

public class Runner {
    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] coins = {1,2,5};
        // int amount = 11;
        int[] coins = {3,5,6};
        int amount = 11;
        System.out.println(s.coinChange(coins, amount));
    }
}
