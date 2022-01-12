package linked_list_cycle_ii;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode result = solution.detectCycle(head);
        helper.BasicFunctions.print(result.val);
    }
}
