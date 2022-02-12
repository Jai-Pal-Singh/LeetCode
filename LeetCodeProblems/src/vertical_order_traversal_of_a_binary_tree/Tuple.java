package vertical_order_traversal_of_a_binary_tree;

import helper_binary_tree.TreeNode;

public class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.vertical = row;
        this.level = col;
    }
}
