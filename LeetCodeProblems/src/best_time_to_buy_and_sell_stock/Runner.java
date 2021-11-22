package best_time_to_buy_and_sell_stock;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BasicFunctions.print(new Solution().maxProfit(prices));
    }
}