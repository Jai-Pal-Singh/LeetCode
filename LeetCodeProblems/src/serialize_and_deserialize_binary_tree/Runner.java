package serialize_and_deserialize_binary_tree;

import helper.BasicFunctions;
import helper_binary_tree.TreeNode;

public class Runner {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        String data = codec.serialize(root);
        BasicFunctions.print(data);
        TreeNode newRoot = codec.deserialize(data);
        TreeNode.print(newRoot);
    }
}
