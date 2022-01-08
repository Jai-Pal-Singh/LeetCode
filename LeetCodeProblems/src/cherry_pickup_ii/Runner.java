package cherry_pickup_ii;

public class Runner {
    public static void main(String[] args) {
        helper.BasicFunctions.print(new Solution().cherryPickup(new int[][]{
                {1, 1, 5},
                {2, 2, 1},
                {1, 2, 5},
                {0, 0, 1},
                {1, 0, 7}
        }));
    }
}
