package delete_columns_to_make_sorted_ii;

import helper.BasicFunctions;

public class Runner {
    public static void main(String[] args) {
        BasicFunctions.print(new Solution().minDeletionSize(new String[]{"ca", "bb", "ac"}));
    }
}
