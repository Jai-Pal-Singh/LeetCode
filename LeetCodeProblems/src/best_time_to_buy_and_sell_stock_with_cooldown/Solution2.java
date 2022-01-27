package best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.HashMap;
import java.util.Map;

/**
 * @link: https://www.youtube.com/watch?v=I7j0F7AHpb8&ab_channel=NeetCode
 */
public class Solution2 {
    Map<String, Integer> dp;
    //buy -> true
    //sell -> false
    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        return dfs(prices, 0, true);
    }
    
    private int dfs(int[] prices, int i, boolean buying){
        if(i>=prices.length){
            return 0;
        }
        if(dp.containsKey(""+i+buying)){
            return dp.get(""+i+buying);
        }
        //cooldown
        int cooldown = dfs(prices, i+1, buying);
        if(buying){
            int buy = dfs(prices, i+1, !buying) - prices[i];
            dp.put(""+i+buying, Math.max(buy, cooldown));
        }
        else{
            int sell = dfs(prices, i+2, !buying) + prices[i];
            dp.put(""+i+buying, Math.max(sell, cooldown));
        }
        return dp.get(""+i+buying);
    }
}
