package search_insert_position;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {
     private static final Logger logger = Logger.getLogger(Runner.class.getName());
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        logger.log(Level.INFO,"Output : {0}" , sol.searchInsert(nums, target));
    }
}
