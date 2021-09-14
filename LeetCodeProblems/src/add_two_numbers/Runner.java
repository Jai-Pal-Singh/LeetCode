package add_two_numbers;

import helper.ListNode;

public class Runner {
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ListNode l1 = new ListNode(2);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);
        // ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        // ListNode l1 = new ListNode(0);
        // ListNode l2 = new ListNode(0);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode result = sol.addTwoNumbers(l1, l2);
        ListNode.print(result);
    }
}
