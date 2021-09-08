package helper;

//   Definition for singly-linked list.
  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static void print(ListNode node){
        System.out.println("Elements in list node:");
        while(node!=null){
          System.out.println(node.val);
          node = node.next;
        }
      }
  }
 