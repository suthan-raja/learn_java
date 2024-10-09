package msp.test.learn.datastrcuture.collection.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main (String[] args){

        Set<Integer> set = new TreeSet<Integer>();

        set.add(7);
        set.add(0);
        set.add(3);
        set.add(9);

        System.out.println(" LinkedHashSet : "+set);

        System.out.println("Contains Using LinkedHashSet Method : "+set.contains(4));
    }
}
