package remove_duplicates_from_sorted_list;

import helper.ListNode;

/* 
Given the head of a sorted linked list,delete all duplicates such that each element appears only once.Return the linked list sorted as well.

Example 1:

Input:head=[1,1,2]Output:[1,2]Example 2:

Input:head=[1,1,2,3,3]Output:[1,2,3]

Constraints:

The number of nodes in the list is in the range[0,300].-100<=Node.val<=100 The list is guaranteed to be sorted in ascending order.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prevTemp = head;
        ListNode currTemp = head.next;
        while (currTemp != null) {
            if (currTemp.val == prevTemp.val) {
                prevTemp.next = currTemp.next;
            } else {
                prevTemp = prevTemp.next;
            }
            currTemp = currTemp.next;
        }
        return head;
    }
}
