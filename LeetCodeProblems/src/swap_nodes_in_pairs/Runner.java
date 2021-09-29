package swap_nodes_in_pairs;

import helper.ListNode;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode result = sol.swapPairs(head);
        ListNode.print(result);
    }
}