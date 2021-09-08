package delete_node_in_a_linked_list;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        sol.deleteNode(node);

        ListNode.print(node);
    }
}
