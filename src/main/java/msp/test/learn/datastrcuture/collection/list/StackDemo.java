package msp.test.learn.datastrcuture.collection.list;

import java.util.*;

public class StackDemo {

    public static void main(String[] args){

        Stack<String> stack = new Stack<String>();

        stack.push("kabilan");
        stack.push("naveen");
        stack.push("sathish");

        System.out.println("STACK : "+stack);

        // Peek method get the last added element without remove that element
        System.out.println("Stack peek() : "+stack.peek());

        // pop() method get and remove the last element.
        System.out.println("Stack pop() : "+stack.pop());

        System.out.println("After Pop : "+stack);

        System.out.println("Get Specific Index : "+stack.get(1));

        System.out.println("stack search and return index : " + stack.search("naveen"));

        Vector<String> list = new Vector<>();
         list.add("kabilan");
         list.add("naveen");
         list.add("sathish");
         list.add("kabilan1");
         list.add("resma");
         list.add("sathish1");

         list.get(5);
        System.out.println("test :"+list.get(4));
        List<Integer> stackInt = new Stack<>();

        stackInt.add(1);
        stackInt.add(2);
        stackInt.add(3);
        stackInt.add(4);

        Iterator<Integer> stackIterator = stackInt.iterator();

        while(stackIterator.hasNext()){
            System.out.println(stackIterator.next());
        }
    }

}
