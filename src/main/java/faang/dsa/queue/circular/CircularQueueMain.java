package faang.dsa.queue.circular;

public class CircularQueueMain {

    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(3);
        System.out.println("Is Empty: " + myCircularQueue.isEmpty());
        System.out.println("Is Full: " + myCircularQueue.isFull());

        myCircularQueue.enqueue(1);
        myCircularQueue.enqueue(2);
        myCircularQueue.enqueue(3);

        System.out.println("Is Empty: " + myCircularQueue.isEmpty());
        System.out.println("Is Full: " + myCircularQueue.isFull());
    }
}
