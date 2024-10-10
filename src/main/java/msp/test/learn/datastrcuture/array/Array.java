package msp.test.learn.datastrcuture.array;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Array {

    /*
    * Array declared variable are stored in stack memory and that Array of values stored in heap memory and point that key in heap inside have
    * a stored array of value address
    *  */

    // Initialize Array
    static int[] initializeArray(){

        String[] strArr = {"Raja" , "king"};
        int[] intArr= {1,2};

        return intArr;

    }

    // Update Array Values
    static void updateArray(){

        int[] intArr = new int[3];
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;

    }

    // Sorting Methods
    static void sortingMethod(){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(38);
        arr.add(45);
        arr.add(65);
        arr.add(7);

        // 1. Collections.sort() To with comparator

        /*Collections.sort( arr , new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            };
        });*/

        // 2. Collections.sort() with lambda

        Collections.sort( arr,  (a,b) -> ( a - b));



        System.out.println("ARRAY LIST : "+ arr);
    }

    public static void arrayMethodsInCollection(){

        int[] arr1 = {1,5,2,7,9};

        int arr[] = new int[10];

        // Arrays Fill
        // This methods fill the given value in all index in that array
        Arrays.fill(arr,1);
        System.out.println("Array : "+Arrays.toString(arr));

        // Arrays sort
        // This method sort the given array
        Arrays.sort(arr1);

        // Arrays length
        // return the length of the array
        System.out.println("Length : "+arr1.length);


    }

    public static void main(String[] args) throws InterruptedException {

        int[] arrVal = initializeArray();

        // Length Property

        int size = arrVal.length;

        // Looping Values

        // 1. For Loop

        for(int i = 0; i < size; i++){
            System.out.println(arrVal[i]);
        }

        //  2. Enhanced For Loop

        for(int val : arrVal){
            System.out.println(val);
        }

        // 3. Real world Array

//        Thread.sleep(10000);

        PaymentArray[] payment = new PaymentArray[5];

        payment[0] = new PaymentArray(1,2,"raja");

        System.out.println("Payment : "+ Arrays.toString(payment));

        int arr[] = new int[26];
        System.out.println(arr[25]);

        // 4. Represent the Game State

        char[][] ticTac = new char[26][26];


        // 5. Sorting Methods
        sortingMethod();

        arrayMethodsInCollection();
    }
}
