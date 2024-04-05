package algorithm.graph;

import java.util.*;

@SuppressWarnings("hiding")
public class LinkedList<Integer> implements Iterable<Integer> {

    private ListNode<Integer> head;
    private int n;

    private static class ListNode<Integer>{
        private Integer data;
        private ListNode<Integer> next;
        
    }

    public LinkedList(){
        head = null;
        n = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    public void add(Integer data){
        ListNode<Integer> oldFirst = head;
        head = new ListNode<>();
        head.data = data;
        head.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
    @SuppressWarnings("unused")
    private class ListIterator<Integer> implements Iterator<Integer>{

        private ListNode<Integer> current;

        public ListIterator(ListNode<Integer> head){
            this.current = head;
        }

        public void remove() { throw new UnsupportedOperationException(); }

        @Override
        public boolean hasNext() {
            return current != null; 
        }

        @Override
        public Integer next() {
            if(!hasNext()) throw new NoSuchElementException();
            Integer data = current.data;
            current = current.next;
            return data;
        }
        
    }
}
