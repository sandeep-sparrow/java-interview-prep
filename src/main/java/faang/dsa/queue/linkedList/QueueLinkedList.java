package faang.dsa.queue.linkedList;

import algorithm.graph.LinkedList;

public class QueueLinkedList {

    private Node first;
    private Node last;
    private int length;

    public QueueLinkedList(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
        System.out.println("The Queue is successully created");
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

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public Node dequeue(){
        if(isEmpty()) return null;
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
