package msp.test.learn.concepts.leetcode.string;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

public class StringLeet {
    public static int romanToInt(String s) {
        StringBuilder roman = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
//          MCMXCIV M - 1000
            int currentVal = map.get(s.charAt(i)); // M
            if (i < n - 1 && currentVal < map.get(s.charAt(i + 1))) {
                total -= currentVal; // 900 1900 - 10 = 1890 1990-1 = 1989
                System.out.println("IF Total is " + total + " Current Value is " + currentVal);
            } else {
                total += currentVal; // 1000 900 + 1000   1890 + 100 = 1990 1990 1989+5 = 1994
                System.out.println("ELSE Total is " + total + " Current Value is " + currentVal);
            }

        }

        System.out.println("Total : " + total);
        return total;
    }

    public static int strStr(String haystack, String needle) {
        char[] characters = needle.toCharArray();
        int text = haystack.length();
        int pattern  = needle.length();
        int index = 0;
        int val = 0;
        // sadbutsad sad
        for(int i = 0 ; i < text ; i++){
            int j ;
            for( j = 0 ; j < pattern ; j++){
                if( index != pattern -1 ){
                    if(haystack.charAt(i) == characters[j]){ // s a d
                        index = index + 1;
                    }
                }else{
                    val = index - (pattern-1);
                }

                System.out.println("Index : "+index + " KK "+haystack.charAt(i));
            }

            if(val == 0 && (pattern - index) > 0){
                return -1;
            }
            String raj = "KK";
//            raj.indexOf()
        }

        System.out.println(" IN : "+index + " Pattern L : "+(pattern-1));
        return val;
    }

    public static String addBinary(String a, String b) {
         // 0 - 9 --> 48 to 56
         // a - z --> 97 to 122 97 - 48
         // A - Z --> 65 to 90
         // space --> 32

        Logger logger  = LoggerFactory.getLogger(StringLeet.class);
        StringBuilder sb = new StringBuilder();
        int aLen = a.length() - 1 , bLen = b.length() - 1 ;
        int sum = 0;
        int get = 0;
        while( aLen >= 0 || bLen >= 0 || get == 1){  // 11  1
            sum = get;
            if(aLen >= 0 ) { // 11
                sum = sum + a.charAt(aLen) - '0'; // 0 + 1  = 1 //  --> char to integer '1' - '0' 49 - 48 = 1
                System.out.println(1 + '0');
            }

            if(bLen >= 0 ){
                sum = sum + b.charAt(bLen) - '0'; // 1 + 1 = 2
            }

            sb.append( (char) (sum % 2 + '0') ); // 2 % 2 = 0 + 0 (48) == 48 ==> (char) 48 == 0
            get = sum / 2 ; // 2 / 2 = 1
            System.out.println(1/2);

            System.out.println(" A : "+ aLen + " B : "+ bLen + "  SUM : "+sum + " GET : "+get);

            aLen--;
            bLen--;
        }

//        logger.info(" TIME ST : "+ LocalDateTime.now().getChronology());


        return sb.reverse().toString();
    }

    private static void checkExcelTitle(int num) {
        HashSet<String> val = new HashSet<>();
        val.add("suthan");
        System.out.println(val.contains("Suthan"));
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while( num > 0){
            rem = num % 26 ;
            if(rem == 0){
                sb.append("Z");
                num = num / 26 - 1 ;
                System.out.println("NUM : "+num);
            }else{
                System.out.println("R : "+rem);
                sb.append((char) ((rem-1) + 'A'));
                num = (num/26);
            }
            System.out.println(" REMAINDER : "+rem +" STRING BUILDER : "+sb.toString());
        }


    }


    public static void main(String[] args) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        romanToInt("MCMXCIV"); // 1994  1000

//        strStr("sadbutsad","sad");

//        String response = addBinary("11","1");
//        System.out.println("RES : "+response);
          checkExcelTitle(28);

       /* try {
            checkErr("[{language=eng, value=Philippines}]");
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }*/
    }

    private static void checkErr(String s) throws JsonProcessingException {

//        s.indexOf("}",6);
//        s.index

        ObjectMapper ob = new ObjectMapper();
        String st = ob.writeValueAsString(s);
        Object  listString =   ob.readValue(st, Object.class);
        System.out.println(listString);
    }


}
