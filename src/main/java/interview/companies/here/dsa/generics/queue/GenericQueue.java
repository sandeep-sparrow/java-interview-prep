package interview.companies.here.dsa.generics.queue;

import interview.companies.here.dsa.generics.GenericNode;

// Horizontal DS
public class GenericQueue<T> {

    GenericNode<T> first;
    GenericNode<T> last;
    private int length;

    public GenericQueue(Object T){
        this.first = new GenericNode<>(T);
        this.last = new GenericNode<>(T);
        this.length = 1;
    }

    public void printQueue(){
        GenericNode<T> temp = this.last;
        int count = length;
        while(count <= length){
            System.out.println("Queue: " + temp.T);
            temp = temp.next;
            count--;
        }
    }

    // 1(l), 2, 3 (f), enqueue(4)
    public void enqueue(Object T){
        GenericNode<T> newNode = new GenericNode<>(T);
        if(length == 0){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    // 1(l), 2, 3 (f)
    public GenericNode<T> dequeue(){
        GenericNode<T> temp = first;
        if(length == 0) return null;
        if(length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
        }
        temp.next = null;
        this.length--;
        return temp;
    }

    public GenericNode<T> getFirst() {
        return first;
    }

    public void setFirst(GenericNode<T> first) {
        this.first = first;
    }

    public GenericNode<T> getLast() {
        return last;
    }

    public void setLast(GenericNode<T> last) {
        this.last = last;
    }

    public int getlength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }
}
