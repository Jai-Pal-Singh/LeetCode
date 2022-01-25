package sort_list;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode.print(new Solution().sortList(head));
    }
}
