package msp.test.learn.datastrcuture.collection.queue;

import java.util.ArrayDeque;

public class ArrayDequeDemo {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        deque.offer(54);
        deque.offer(44);
        deque.offerFirst(90);
        deque.offerLast(90);

        System.out.println("ArrayDeque : " + deque);

        System.out.println("Poll : " + deque.poll());
        System.out.println("Poll First : " + deque.pollFirst());
        System.out.println("Poll Last : " + deque.pollLast());

        System.out.println("After poll : " + deque);

        deque.offerFirst(90);
        deque.offerLast(30);
        System.out.println("After add something : " + deque);

        System.out.println("Deque Peek : "+deque.peek());
        System.out.println("Deque Peek First : "+deque.peekFirst());
        System.out.println("Deque Peek Last : "+deque.peekLast());

        System.out.println("After peek something : " + deque);
    }

}
