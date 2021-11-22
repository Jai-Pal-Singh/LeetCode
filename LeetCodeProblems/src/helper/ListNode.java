package helper;

import java.util.logging.Level;
import java.util.logging.Logger;

//   Definition for singly-linked list.
  public class ListNode {

    private static final Logger logger = Logger.getLogger(ListNode.class.getName());
    private static final String EMPTY_STRING = "{0}";

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    

    public static void print(ListNode node){
      logger.info("Elements in list node:");
      while(node!=null){
        logger.log(Level.INFO, EMPTY_STRING, node.val);
        node = node.next;
      }
    }
  }
 