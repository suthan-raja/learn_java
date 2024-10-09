package msp.test.learn.datastrcuture.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<Integer>();

        queue.offer(90);
        queue.offer(2);
        queue.offer(13);
        queue.offer(43);
        queue.offer(55);

        System.out.println("Priority Queue : " + queue);

        queue.poll();


        System.out.println("after poll : " + queue);

        PriorityQueue<Integer> queueClass = new PriorityQueue<Integer>();

        queueClass.offer(90);
        queueClass.offer(2);
        queueClass.offer(13);
        queueClass.offer(43);
        queueClass.offer(55);
        System.out.println("Priority Queue : " + queueClass);

        queueClass.poll();

        System.out.println("after poll : " + queueClass);

        // Reverse Order Priority Queue

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.offer(90);
        priorityQueue.offer(2);
        priorityQueue.offer(13);
        priorityQueue.offer(43);
        priorityQueue.offer(55);

        System.out.println("Reverse Order Priority Queue : " + priorityQueue);
    }

}
