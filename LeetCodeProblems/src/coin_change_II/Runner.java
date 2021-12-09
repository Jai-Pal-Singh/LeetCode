package coin_change_II;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 5;
        helper.BasicFunctions.print(solution.change(amount, coins));
    }
}
