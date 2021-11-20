package binary_search;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        System.out.println(new Solution().search(arr, target));
    }
}