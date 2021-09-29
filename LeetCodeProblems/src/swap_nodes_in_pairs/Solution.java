package swap_nodes_in_pairs;

import helper.ListNode;

// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// Example 2:

// Input: head = []
// Output: []
// Example 3:

// Input: head = [1]
// Output: [1]
 

// Constraints:

// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next !=null){
            ListNode temp = head.next;
            ListNode next = head.next.next;
            temp.next = head;
            head.next = swapPairs(next);
            return temp;
        }
        else{
            return head;
        }
    }
}
