package reverse_linked_list;

import helper.ListNode;

public class Runner {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode result = sol.reverseList(head);
        ListNode.print(result);
    }
    
}
