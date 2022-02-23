package helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Node {

    private static final Logger logger = Logger.getLogger(Node.class.getName());
    private static final String EMPTY_STRING = "{0}";
    private static final String NEIGHBORS_STRING = "Neighbors for {0} : {1}";

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    public Node random;
    public Node child;
    public List<Node> neighbors;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        this.val = _val;
        this.random = null;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
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

    public static void printNeighbors(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();
        if (root == null)
            return;
        queue.add(root);
        logger.info("Elements in list node:");
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(!seen.contains(temp)){
                logger.log(Level.INFO, NEIGHBORS_STRING, new Object[]{temp.val, temp.neighbors.stream().map(Node::getVal).collect(Collectors.toList())});
                queue.addAll(temp.neighbors);
            }
            seen.add(temp);            
        }
    }
}
