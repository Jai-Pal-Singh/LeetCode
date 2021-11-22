package remove_n_th_node_from_end_of_list;

import helper.ListNode;

/* 
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        if(len==n){
            //remove from front
            return removeFromFront(head);
        }
        else if(len>1 && n==1){
            //remove from end
            return removeFromEnd(head, len);
        }
        else{
            //remove from middle
            return removeFromMiddle(head, n, len);
        }       
    }
    
    public ListNode removeFromFront(ListNode head) {
        return head.next;
    }
    
    public ListNode removeFromEnd(ListNode head, int len) {
        ListNode temp = head;
        int i = 1;
        while(i<len-1){
            temp = temp.next;
            i++;
        }
        temp.next = null;
        return head;
    }
    
    public ListNode removeFromMiddle(ListNode head, int n, int len) {
        ListNode temp = head;
        int i = 1;
        while(i<(len-n)){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
}
