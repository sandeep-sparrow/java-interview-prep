package datastructure.collections.queue;

public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(5);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.enqueue(10);
        System.out.println("--- enqueue ---");
        myQueue.getLength();
        myQueue.getFirst();
        myQueue.getLast();
        System.out.println("dequeue value: " + myQueue.dequeue().value);
        System.out.println("--- dequeue ---");
        myQueue.getLength();
        myQueue.getFirst();
        myQueue.getLast();
        System.out.println("dequeue value: " + myQueue.dequeue().value);
        System.out.println("--- dequeue ---");
        System.out.println("dequeue value: " + myQueue.dequeue());

    }
}
