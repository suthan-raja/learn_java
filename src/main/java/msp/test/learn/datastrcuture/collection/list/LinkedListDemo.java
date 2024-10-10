package msp.test.learn.datastrcuture.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {


    public static void methods(){

        List<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println("Int List : " + intList);

        intList.add(2 , 18);

        System.out.println("Added Index with Element : "+intList);

        List<Integer> secondIntList = new LinkedList<>();
        secondIntList.add(1);
        secondIntList.addAll(intList);

        System.out.println("ADD ALL LIST : "+secondIntList);

        intList.remove(1);

        System.out.println("Index Based Removed : "+intList);

        secondIntList.removeAll(intList);

        System.out.println("Removed All In int List : "+secondIntList);

        secondIntList.clear();

        System.out.println("Cleared Second List : "+secondIntList);

        boolean val = intList.contains(3);

        System.out.println("Contains : 3 " +val);

        int singleVal = intList.get(0);

        System.out.println("Get Using Fetching Value based on index : "+singleVal);

        int index = intList.indexOf(singleVal);

        System.out.println("Index of Method to fetch index : "+index);

        boolean isEmpty = secondIntList.isEmpty();

        System.out.println("Check 2nd List is Empty : "+isEmpty);

        int lastIndex =  intList.lastIndexOf(18);

        System.out.println("Last Index of given value  : "+lastIndex);

        intList.set(0 , 20);

        System.out.println("set the specific index into the new value : "+intList);

        int size = intList.size();

        System.out.println("Size : "+size);

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        // For Each Loop
        for(int s : integerList){
            System.out.println("VALS : "+s);
        }

        // Using Iterator
        Iterator<Integer> listIterator = integerList.iterator();
        while(listIterator.hasNext()){
            System.out.println("Iterator : "+listIterator.next());
        }

        System.out.println("Linked List Methods : ");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.addFirst(5);
        linkedList.addLast(6);

        linkedList.offerFirst(7);
        linkedList.poll();

        System.out.println("Linked List : "+linkedList);

    }

    public static void main(String[] args) {
        methods();
    }

}
