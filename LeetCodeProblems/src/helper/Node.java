package helper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Node {

    private static final Logger logger = Logger.getLogger(Node.class.getName());
    private static final String EMPTY_STRING = "{0}";

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    public Node random;
    public Node child;

    public Node() {
    }

    public Node(int _val) {
        this.val = _val;
        this.random = null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void print(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        logger.info("Elements in list node:");
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            logger.log(Level.INFO, EMPTY_STRING, temp.val);
        }
    }
}
