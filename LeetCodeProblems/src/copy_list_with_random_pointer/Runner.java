package copy_list_with_random_pointer;

import helper.Node;

public class Runner {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.next = new Node(13); 
        root.next.next = new Node(11);  
        Node.print(root);
        Node.print(new Solution().copyRandomList(root));
    }
}
