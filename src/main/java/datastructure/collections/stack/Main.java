package datastructure.collections.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(1);

        myStack.push(2);
        myStack.push(3);

        myStack.printStack();

        Node poppped;
        System.out.println("--- POP ---");
        poppped = myStack.pop();
        System.out.println("Popped Node: " + poppped.value);
        myStack.printStack();
    }
}
