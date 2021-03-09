package stack_with_linked_list;
import java.util.Objects;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = new Node();
    }

    public void insert(Integer data) {
        Node node = new Node();
        node.setData(data);
        node.setNext(null);

        if(Objects.isNull(head.getData())){
            head = node;
        }
        else{
            Node n = head;
            while(Objects.nonNull(n.getNext())){
                n = n.getNext();
            }
            n.setNext(node);
        }

    }
    public void insertAtStart(Integer data){
        Node node = new Node();
        node.setData(data);
        node.setNext(null);
        if(Objects.isNull(head)){
            head = node;
        }
        else {
            node.setNext(head);
            head = node;
        }
    }

    public void insertAt(Integer index,Integer data){
        Node node = new Node();
        node.setData(data);
        node.setNext(null);

        if(index==0)
        {
            insertAtStart(data);
        }
        else{
            Node n = head;
            for(int i=0;i<index-1;i++)
            {
                n = n.getNext();
            }
            node.setNext(n.getNext());
            n.setNext(node);
        }
    }

    public void deleteAt(Integer index)
    {
        if(index.equals(0))
        {
            System.out.println("Popping "+ head.getData());
            head = head.getNext();
        }
        else
        {
            Node n = head;
            Node n1 = null;
            for(int i=0;i<index-1;i++)
            {
                n = n.getNext();
            }
            n1 = n.getNext();
            n.setNext(n1.getNext());
            System.out.println("Popping " + n1.getData());
            n1 = null;
        }
    }

    public void show()
    {
        Node node = head;

        while(Objects.nonNull(node.getNext()))
        {
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println(node.getData());
    }

    public Node getHead() {
        return head;
    }
}
