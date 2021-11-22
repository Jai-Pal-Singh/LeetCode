package remove_n_th_node_from_end_of_list;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode.print( new Solution().removeNthFromEnd(head, 5));
    }
}
