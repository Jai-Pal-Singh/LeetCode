package middle_of_the_linked_list;

import helper.ListNode;

public class Solution2 {
    public ListNode middleNode(ListNode head) {
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        len = (len/2)+1;
        temp = head;
        int i = 1;
        while(i<len){
            temp = temp.next;
            i++;
        }
        return temp;
    }
}
