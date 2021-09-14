package add_two_numbers;

import helper.ListNode;

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:


// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
 

// Constraints:

// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansHead;

        ListNode ans = new ListNode();
        ans.val = (l1.val + l2.val)%10;
        int carry = (l1.val + l2.val)/10;
        ansHead = ans;


        while(l1.next!=null && l2.next !=null){
            l1 = l1.next;
            l2 = l2.next;

            ListNode temp = new ListNode();
            temp.val = (carry + l1.val + l2.val)%10;
            carry = (carry + l1.val + l2.val)/10;

            ans.next = temp;
            ans = ans.next;
        }

        if(l1.next!=null){
            while(l1.next!=null ){
                l1 = l1.next;

                ListNode temp =new ListNode();
                temp.val = (carry + l1.val)%10;
                carry = (carry + l1.val)/10;

                ans.next = temp;
                ans = ans.next;
            }
        }

        if(l2.next!=null){
            while(l2.next!=null ){
                l2 = l2.next;

                ListNode temp = new ListNode();
                temp.val = (carry + l2.val)%10;
                carry = (carry + l2.val)/10;

                ans.next = temp;
                ans = ans.next;
            }
        }

        if(carry > 0){
             ListNode temp = new ListNode();
                temp.val = carry;
                ans.next = temp;
        }
        return ansHead;
    }
}
