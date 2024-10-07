package msp.test.learn.concepts.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StringConcepts {

    public static void pattern(String pattern) {

//        1.


        for (int i = 0; i < pattern.length(); i++) { // 0  1  2
            for (int j = 0; j < pattern.length(); j++) { // 0  1 2
                if (j == i || j == (pattern.length() - 1) - i) { // 0 == 0 , 4 == 4 , 1 == 1 , 3 == 3 , 2 == 2
                    System.out.print(pattern.charAt(j));  // 1  5    2  4  3
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern2(String word) {
//        PROGRAM
        int lenHalf = (word.length() - 1) / 2;
        System.out.println(lenHalf);
        for (int i = 0; i < word.length(); i++) { // 0 1 2 3 4
//            for (int j = 0; j < lenHalf; j++) {
            for (int j = 0; j < word.length() - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = word.length() - 1 - i; j >= lenHalf; j--) { // 6
                if (j == i || j == (word.length() - 1) - i) {
                    System.out.print(" " + "G" + word.charAt(lenHalf + i)); // 3  4  5  6
                }
            }
            System.out.println();
        }
    }

    public static void newString(){
        byte[] newByte = { 83 , 117 , 116 , 104 , 97 , 110 };
        Charset ewChar = Charset.defaultCharset();
        String newS = new String(newByte , ewChar);
        String string = new String(newByte);
        System.out.println(string);
        System.out.println(newS);

        try {
            String newStr = new String(newByte , "US-ASCII");
            System.out.println(newStr);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        int[] intArr = { 83 , 117 , 116 , 104 , 97 , 110 };
        String newString = new String(intArr , 0 ,6);
        System.out.println(newString);
    }

    private static void StringMethods(String str){

        // length()
        System.out.println("String Len : "+str.length());

        // CharAt()
        System.out.println("String charAt : "+str.charAt(4));

        // Substring()
        System.out.println("String substr : "+str.substring(0 , 4));

        // concat()
        String s1 = "Suthanu";
        String s2 = " Raja";
        s1.concat(s2);
        System.out.println("Concat Without new String  : "+s1);
        String s3 = s1.concat(s2);
        System.out.println("Concat With new String  : "+s3);

        // indexOf()
        System.out.println("Index of : "+s1.indexOf("u"));
        System.out.println("Index of specified starting position : "+s1.indexOf("u",4));
        System.out.println("Index of not in that value return -1 : "+s2.indexOf("u",4));

        // lastIndexOf()
        System.out.println(s1.lastIndexOf("u"));

        // equals()
        String s4 = "suthanu";
        System.out.println(" Equals : " + s1.equals(s4));

        // equalsIgnoreCase()
        System.out.println(" Equals Ignore Case : "+s1.equalsIgnoreCase(s4));

        // compareTo()
        int compareTo  = s1.compareTo(s4);
        System.out.println("Compare To : "+compareTo);

        // compareToIgnoreCase()
        int compareToIgnoreCase = s1.compareToIgnoreCase(s4);
        System.out.println("Compare TO Ignore Case : "+compareToIgnoreCase);

        // toLowerCase()
        System.out.println("Lower Case : " + s1.toLowerCase());

        // toUpperCase()
        System.out.println("Upper Case : "+s1.toUpperCase());

        // trim() - removes the white spaces start and end not in middle
        System.out.println("REMOVE WHITE SPACE TRIM : "+"   KI  NG   ".trim());

        // replace( char c1 , char c2 )
        System.out.println("Replace : "+s1.replace("u","m"));

        // contains(CharSequence c)
        System.out.println(" Contains character : "+s1.contains("u"));
        System.out.println(" Contains character sequence : "+s1.contains("ut"));

        // toCharArray()
        char[] character = s1.toCharArray();
        System.out.println(" String to Char Array : "+ Arrays.toString(character));

        // startsWith()
        System.out.println("Starts With : "+s1.startsWith("s"));
        System.out.println("Ends With : "+s1.endsWith("s"));

    }

    public static String StringORBufferORBuilder(String sq){
//        String s = "suthan";
        sq+= "raja";
        return sq;
    }


    public static void main(String[] args) {


//        1   5
//         2 4
//          3
//         2 4
//        1   5

//        pattern("12345");


//        Pattern 2

//        pattern2("PROGRAM");

//        newString();

//        StringMethods("Suthan");

         String s = "suthan" ;
         StringORBufferORBuilder(s);
        System.out.println(s);

    }
}
