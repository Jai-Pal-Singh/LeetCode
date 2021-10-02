package merge_two_sorted_list;

import helper.ListNode;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode();
        l2.val = 1;
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode res = sol.mergeTwoLists(l1, l2);
        ListNode.print(res);
    }
}