package stack_with_linked_list;
public class Stack {
    private LinkedList list;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public Stack() {
        this.list = new LinkedList();
        this.size = 0;
    }

    public void push(Integer data){
        if (size.equals(0)){
            list.insert(data);
            size++;
        }
        else {
            list.insertAtStart(data);
            size++;
        }
    }

    public void pop(){
        list.deleteAt(0);
        size--;
    }

    public void peek(){
        System.out.println(list.getHead().getData());
    }

    public void show(){
        if (size > 0) {
            list.show();
        }
        else {
            System.out.println("Stack is empty");
        }
    }

    public Boolean isEmpty(){
        return getSize().equals(0) ? true : false;
    }
}
