package interview.companies.here.dsa.generics;

import interview.companies.here.dsa.generics.queue.GenericQueue;
import interview.companies.here.dsa.generics.stack.GenericStack;

public class GenericMain {
    public static void main(String[] args) {
        GenericStack<Integer> myStack = new GenericStack<>(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println("*** Generic Stack ***");
        myStack.printStack();
        System.out.println("--- POP  TOP  Node ---");
        GenericNode<Integer> myPoppedNode = myStack.pop();
        System.out.println(myPoppedNode.T);
        myStack.printStack();

        System.out.println("*** Generic Queue ***");
        GenericQueue<Integer> myQueue = new GenericQueue<>(50);
        myQueue.enqueue(100);
        myQueue.printQueue();
        myQueue.enqueue(200);
        myQueue.printQueue();
        System.out.println("---- Queue - de queue ----");
        System.out.println(myQueue.getlength());
        System.out.println(myQueue.dequeue().T);
        myQueue.printQueue();
    }

}
