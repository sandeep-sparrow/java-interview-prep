package faang.dsa.queue;

public class QueueArray {

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size){
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue successfully created with size: " + size);
    }

    public boolean isFull(){
        return topOfQueue == arr.length - 1;
    }

    public boolean isEmpty(){
        return (beginningOfQueue == -1) || (beginningOfQueue == arr.length);
    }

    // INSERTION
    public void enqueue(int value){
        if(isFull()){
            System.out.println("The queue is full!");
        }else if(isEmpty()){
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Success insertion of value: " + value + " in the queue");
        } else{
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Success insertion of value: " + value + " in the queue");
        }
    }

    // REMOVAL
    public int dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return -1;
        }else{
            // return 1st element
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
            return result;
        }
    }

    // PEEK
    public int peek(){
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return -1;
        }else{
            return arr[beginningOfQueue];
        }
    }

    // DELETION
    public void deleteQueue(){
        arr = null;
        System.out.println("The queue is successfully deleted");
    }
}
