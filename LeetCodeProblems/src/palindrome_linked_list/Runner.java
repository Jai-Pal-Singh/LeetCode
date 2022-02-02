package palindrome_linked_list;

import helper.BasicFunctions;
import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        BasicFunctions.print(new Solution().isPalindrome(head));
    }
}
