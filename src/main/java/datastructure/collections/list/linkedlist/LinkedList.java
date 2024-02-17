package datastructure.collections.list.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
    LinkedList implements List interface and extends abstractSequentialList
    Big O - time Complexity of LinkedList.

    append() -> O(1)

    prepend() -> O(1)

    removeLast() -> O(n)

    removeFirst() -> O(1)

    insert() -> O(n)

    remove() -> O(n)

    get() -> O(n) byValue or byIndex, here ArrayList out performance LinkedList
*/
public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;
    private int length;

    public LinkedList(int value){
        LinkedNode newNode = new LinkedNode(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        LinkedNode temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printAll(){
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value){
        LinkedNode newNode = new LinkedNode(value);
        if(length == 0){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public LinkedNode removeLast(){
        if(length == 0) return null;
        LinkedNode temp = head;
        LinkedNode pre = head;

        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        LinkedNode newNode = new LinkedNode(value);
        if(length == 0){
            tail = newNode;
        }else{
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public LinkedNode removeFirst(){
        if(length == 0) return null;
        LinkedNode temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public LinkedNode get(int index){
        if(index < 0 || index >= length){ // don't forget this line
            return null;
        }
        LinkedNode temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        LinkedNode temp = get(index);
        if(temp != null){
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        LinkedNode newNode = new LinkedNode(value);
        LinkedNode temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public LinkedNode remove(int index){
        if(index < 0 || index >= length) return null;

        if(index == 0) return removeFirst();

        if(index == length -1) return removeLast();

        LinkedNode pre = get(index -1);
        LinkedNode temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public LinkedNode getHead(){
        return head;
    }

    public LinkedNode getTail(){
        return tail;
    }

    public int getLength(){
        return length;
    }

    public void reverse(){
        LinkedNode temp = head;
        head = tail;
        tail = temp;
        LinkedNode after = temp.next;
        LinkedNode before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before; //flips the arrow
            before = temp;
            temp = after;
        }
    }

    /*
    This Method is to be able to detect if there is a cycle or loop present in the LinkedList
    method utilize Floyd's cycle finding algorithm, also known as 'tortoise and hare' algorithm.
     */
    public boolean hasLoop(){
        LinkedNode slow = head;
        LinkedNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public LinkedNode findMiddleNode(){ // 1, 2, 3, 4, 5
        LinkedNode slow = head;
        LinkedNode fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void removeDuplicates(){ // 1, 2, 3, 4, 3, 5
        Set<Integer> values = new HashSet<>();
        LinkedNode previous = null;
        LinkedNode current = head;
        while (current != null){
            if(values.contains(current.value)){
                previous.next = current.next;
            }else{
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    public LinkedNode findKthFromEnd(int k){ // 4, 3, 2, 1
        LinkedNode slow = head;
        LinkedNode fast = head;
        for(int i = 0; i < k; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next; // 3
        }
        while(fast != null){
            slow = slow.next; //
            fast = fast.next; // 4, 5
        }
        return slow;
    }
}
