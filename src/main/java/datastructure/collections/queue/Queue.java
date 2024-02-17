package datastructure.collections.queue;

public class Queue {

    //FIFO
    private Node first;
    private Node last;
    private int length;

    public static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void getFirst(){
        System.out.println("First: " + first.value);
    }

    public void getLast(){
        System.out.println("Last: " + last.value);
    }

    //EN-QUEUE - adding something from the list
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    //DE-QUEUE - removing something from the list
    public Node dequeue(){
        if(length == 0) return null;
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
