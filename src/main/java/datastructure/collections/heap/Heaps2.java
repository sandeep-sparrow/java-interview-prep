package datastructure.collections.heap;

import java.util.ArrayList;

public class Heaps2 {

    public static void main(String[] args) throws Exception {
        
        MaxHeap<Integer> heap = new MaxHeap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
    
}
