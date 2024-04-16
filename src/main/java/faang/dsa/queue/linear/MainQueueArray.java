package faang.dsa.queue.linear;

public class MainQueueArray {

    public static void main(String[] args) {

        QueueArray myQueueArray = new QueueArray(3);
        System.out.println("Queue is Empty: " + myQueueArray.isFull());
        System.out.println("Queue is Empty: " + myQueueArray.isEmpty());

        myQueueArray.enqueue(10);
        myQueueArray.enqueue(11);
        myQueueArray.enqueue(12);
        myQueueArray.enqueue(13);

        System.out.println("Result of 1st dequeue: " + myQueueArray.dequeue());
        System.out.println("Result of peek: " + myQueueArray.peek());
        System.out.println("Result of 2nd dequeue: " + myQueueArray.dequeue());
        System.out.println("Result of 3rd dequeue: " + myQueueArray.dequeue());
        System.out.println("Result of dequeue: " + myQueueArray.dequeue());
        System.out.println("Result of peek: " + myQueueArray.peek());

        myQueueArray.deleteQueue();

    }
}
