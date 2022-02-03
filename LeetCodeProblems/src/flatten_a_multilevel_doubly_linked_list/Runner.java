package flatten_a_multilevel_doubly_linked_list;

import helper.Node;

public class Runner {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2); root.prev = root;
        root.next.next = new Node(3); root.next.prev = root.next;
        Node.print(new Solution().flatten(root));
    }
}
