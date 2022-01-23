package merge_k_sorted_lists;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);  
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);  
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);  
        l3.next = new ListNode(6);

        ListNode.print(new Solution().mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
