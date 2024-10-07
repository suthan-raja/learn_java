package msp.test.learn.concepts.string;

public class StringBufferClass {

    /*
    * StringBuffer is a class in Java that represents a mutable sequence of characters. It provides an alternative to the
    * immutable String class, allowing you to modify the contents of a string without creating a new object every time.
    */

    private static void StringBufferMethods(){
        StringBuffer sb = new StringBuffer();

        // 1. capacity
        System.out.println(sb.capacity());

        // 2. append
        sb.append("Suthan");
        System.out.println(sb.capacity());

        // 3. insert
        sb.insert(1,"R");
        System.out.println(sb);

        // 4. replace
        sb.replace(1,1,"");
        System.out.println(sb);

        // 5. delete
        sb.delete(1,3);
        System.out.println(sb);

        // 6. reverse
        sb.reverse();
        System.out.println(sb);

        // 7. charAt
//        sb.charAt(4);/
        System.out.println("Char At : "+sb.charAt(2));

        // 8.ensureCapacity
//        System.out.println(sb.ensureCapacity(3));

        /*StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.capacity());
        sb2.append("1234567890612345");
        System.out.println(sb2.capacity());
        sb2.append("12345678901");
        System.out.println(sb2.capacity());*/
    }

    public static void main(String[] args) {
            StringBufferMethods();
    }

}
