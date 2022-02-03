package rotate_list;

import helper.ListNode;

/**
 * Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */

 
/**
 * Steps to the algorithm:-

Calculate length of the list
Connect the last node to the first node, converting it to a circular linked list.
Iterate to cut the link of the last node and start a node of k%length of list rotated list.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null||k == 0) return head;
        //calculating length
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head;
        k = k%length; //when k is more than length of list
        int end = length-k; //to get end of the list
        while(end--!=0) temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }
}
