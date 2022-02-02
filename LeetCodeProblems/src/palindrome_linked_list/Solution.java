package palindrome_linked_list;

import helper.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
 */

 
/**
 * Solution 2: Optimized Solution

Approach:

Following are the steps to this approach:-

Find the middle element of the linked list. Refer to this article to know the steps https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
Reverse linked list from next element of middle element. Refer to this article to know the steps https://takeuforward.org/data-structure/reverse-a-linked-list/
Iterate through the new list until the middle element reaches the end of the list.
Use a dummy node to check if the same element exists in the linked list from the middle element.

Time Complexity: O(N/2)+O(N/2)+O(N/2)

Reason: O(N/2) for finding the middle element, reversing the list from the middle element, and traversing again to find palindrome respectively.

Space Complexity: O(1)
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while(slow!=null) {
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode ptr) {
        ListNode pre=null;
        ListNode nex=null;
        while(ptr!=null) {
            nex = ptr.next;
            ptr.next = pre;
            pre=ptr;
            ptr=nex;
        }
        return pre;
    }
}
