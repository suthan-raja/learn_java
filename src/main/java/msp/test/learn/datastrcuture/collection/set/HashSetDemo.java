package msp.test.learn.datastrcuture.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main (String[] args){

        Set<Integer> set = new HashSet<Integer>();

        set.add(16);
        set.add(6);
        set.add(3);
        set.add(9);

        System.out.println("Set : "+set);

        System.out.println("Contains Using Set Method : "+set.contains(4));


        // HashSet using For Given Object

        Set<BookForSet> book = new HashSet<>();
        book.add(new BookForSet("naveen", 1,"navis",260));
        book.add(new BookForSet("naveen", 2,"navis",260));
        book.add(new BookForSet("naveen", 1,"navis",260));

        System.out.println(book);
    }

}
