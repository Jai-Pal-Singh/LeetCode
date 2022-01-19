package binary_search_tree_iterator;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3, new TreeNode(1), new TreeNode(5)), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bSTIterator = new BSTIterator(root);
        BasicFunctions.print(bSTIterator.next());
        BasicFunctions.print(bSTIterator.next());
        BasicFunctions.print(bSTIterator.hasNext());
        BasicFunctions.print(bSTIterator.next());
        BasicFunctions.print(bSTIterator.hasNext());
        BasicFunctions.print(bSTIterator.next());
        BasicFunctions.print(bSTIterator.hasNext());
        BasicFunctions.print(bSTIterator.next());
        BasicFunctions.print(bSTIterator.hasNext());
    }
}
