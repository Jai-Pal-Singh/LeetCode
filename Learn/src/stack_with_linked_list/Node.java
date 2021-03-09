package stack_with_linked_list;
public class Node {
   private Integer data;
   private Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
