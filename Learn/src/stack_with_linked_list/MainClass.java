package stack_with_linked_list;
public class MainClass {

    public static void main(String[] args){
        System.out.println("Linked List operations");
        LinkedList list = new LinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        list.insertAtStart(25);

        list.insertAt(0, 55);

        list.deleteAt(2);

        list.show();

        System.out.println("Stack operations");
        Stack stack = new Stack();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        System.out.println("Current Stack Values");
        stack.show();

        stack.pop();
        System.out.println("Current Stack Values");
        stack.show();
        System.out.println("Current Stack Size : "+ stack.getSize());
        System.out.println("Top Element: ");
        stack.peek();
        System.out.println("Stack Empty? : "+ stack.isEmpty());
    }
}
