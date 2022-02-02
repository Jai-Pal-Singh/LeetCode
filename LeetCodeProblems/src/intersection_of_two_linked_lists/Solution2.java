package intersection_of_two_linked_lists;

/**
 * Approach:

The difference of length method requires various steps to work on it. Using the same concept of difference of length, a different approach can be implemented. The process is as follows:-

Take two dummy nodes for each list. Point each to the head of the lists.
Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.

 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next;
            d2 = d2 == null? headA:d2.next;
        }
        return d1;
    }
}
