package linked_list_random_node;

import helper.ListNode;

public class Runner {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        helper.BasicFunctions.print(solution.getRandom());
        helper.BasicFunctions.print(solution.getRandom());
        helper.BasicFunctions.print(solution.getRandom());
        helper.BasicFunctions.print(solution.getRandom());
        helper.BasicFunctions.print(solution.getRandom());
    }
}
