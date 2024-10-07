package msp.test.learn.concepts.string;

public class StringBuilderClass {


    public static void stringBuilderMethods(){
        StringBuilder s1 = new StringBuilder();
        s1.append("Hello");
        System.out.println(s1.capacity());

        // 1.appendCodePoint -- ASCII
        s1.appendCodePoint(97);

        // 2.code point at -- ASCII
        System.out.println(s1.codePointAt(2) + "  :  "+s1.charAt(2));

        // 3. code point before
        System.out.println(s1.codePointBefore(2));

        System.out.println(s1.capacity());
        System.out.println(s1);
        System.out.println(s1.length());
    }
    public static void main(String[] args){
        stringBuilderMethods();
    }
}
