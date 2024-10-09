package msp.test.learn.datastrcuture.collection.list;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main (String[] args){

        Queue<Integer> queue = new LinkedList<Integer>();

        Integer val = queue.peek();

//        queue.remove();

        queue.add(2);
        queue.add(3);

        System.out.println("Empty queue using peek() : "+val); // null
        System.out.println("queue using peek()       : "+queue.peek());


        Queue<String> queue2 = new LinkedList<String>();

        System.out.println("Empty Queue Poll method : "+queue2.poll());

        queue2.offer("17");

        System.out.println("Val Queue : "+queue2.poll());

        System.out.println("After Poll() : "+queue2);
    }

}
