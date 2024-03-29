package reverse_nodes_in_k_group;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.reverseKGroup(head, 2);
        helper.ListNode.print(head);
    }
}
