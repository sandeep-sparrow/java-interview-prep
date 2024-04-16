package faang.dsa.queue.circular;

public class CircularQueue {

    public int[] arr;
    public int topofQueue;
    public int beginningOfQueue;
    public int size;

    // TIME COMPLEXITY = O(1)
    // SPACE COMPLEXITY = O(n);
    // Create Queue
    public CircularQueue(int size){
        this.arr = new int[size];
        this.size = size;
        this.topofQueue = -1; // we don't have any element in our queue
        this.beginningOfQueue = -1; // we don't have any element in our queue
        System.out.println("Circular queue is successfully created with size of " + size);
    }

    // IS EMPTY?
    // TIME COMPLEXITY = O(1)
    // SPACE COMPLEXITY = O(1);
    public boolean isEmpty(){
        return topofQueue == -1;
    }

    // IS FULL?
    // TIME COMPLEXITY = O(1)
    // SPACE COMPLEXITY = O(1);
    public boolean isFull(){
        if(topofQueue+1 == beginningOfQueue){
            return true;
        }else return beginningOfQueue == 0 && topofQueue + 1 == size;
    }

    // enQueue(value)
    // TIME COMPLEXITY = O(1)
    // SPACE COMPLEXITY = O(1);
    public void enqueue(int value){
        if(isFull()){
            System.out.println("The Queue is full");
        }else if(isEmpty()){
            beginningOfQueue = 0;
            topofQueue++;
            arr[topofQueue] = value;
            System.out.println("Success insertion of value: " + value + " in the queue");
        }else{
            // to use unused cell
            if(topofQueue+1 == size){
                topofQueue = 0;
            }else{
                topofQueue++;
            }
            arr[topofQueue] = value;
            System.out.println("Success insertion of value: " + value + " in the queue");
        }
    }
}
