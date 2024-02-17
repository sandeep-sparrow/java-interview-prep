package datastructure.collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> pr = new PriorityQueue<>();

        pr.add(750);
        pr.add(900);
        pr.add(350);
        pr.add(150);

        // it will by default store in ASC order
        // HEAD(least) will be 150 and REAR(High) will be 900
        System.out.println(pr.poll());


    }
}
