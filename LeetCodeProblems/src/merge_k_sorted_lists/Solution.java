package merge_k_sorted_lists;

import helper.ListNode;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */

/**
 * Solution
 * Approach 4: Merge lists one by one
Algorithm

Convert merge \text{k}k lists problem to merge 2 lists (\text{k-1}k-1) times. Here is the merge 2 lists problem page.

Complexity Analysis

Time complexity : O(kN)O(kN) where \text{k}k is the number of linked lists.

We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
Sum up the merge process and we can get: O(\sum_{i=1}^{k-1} (i*(\frac{N}{k}) + \frac{N}{k})) = O(kN)O(∑ 
i=1
k−1
​
 (i∗( 
k
N
​
 )+ 
k
N
​
 ))=O(kN).
Space complexity : O(1)O(1)

We can merge two sorted linked list in O(1)O(1) space.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
           return lists[0];
       }
       if(lists.length==0){
           return null;
       }
       ListNode head = mergeTwoLists(lists[0],lists[1]);
       for (int i = 2; i < lists.length; i++) {
           head = mergeTwoLists(head,lists[i]);
       }
       return head;
   }
   
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode h = new ListNode(0);
       ListNode ans=h;
       while (l1 != null && l2 != null) {
           if (l1.val < l2.val) {
               h.next = l1;
               h = h.next;
               l1 = l1.next;
           } else {
               h.next = l2;
               h = h.next;
               l2 = l2.next;
           }
       }
       if(l1==null){
           h.next=l2;
       }
       if(l2==null){
           h.next=l1;
       } 
       return ans.next;
   }
}
