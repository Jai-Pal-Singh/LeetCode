package populating_next_right_pointers_in_each_node_ii;

import helper.Node;

public class Runner {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        helper.Node.print(new Solution().connect(root));
    }
}
