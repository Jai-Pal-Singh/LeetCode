package convert_sorted_array_to_binary_search_tree;

import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {-10, -3, 0, 5, 9};
        TreeNode.print(solution.sortedArrayToBST(num));
    }
}
