package msp.test.learn.algorithm.search;

import java.util.Arrays;

public class LinearSearchAlgorithm {


        public static int findIndex(int[] array, int value) {

            for(int i = 0 ; i < array.length ; i++){

                if(array[i] == value){
                    return i;
                }
            }

            return -1;
        }

        public static boolean findAndCheck(int[] array, int value) {

            for(int i = 0 ; i < array.length ; i++){

                if(array[i] == value){
                    return true;
                }
            }

            return false;
        }

        public static boolean findString(String string, char value) {
            for(int i = 0 ; i < string.length() ; i++){
                if(string.charAt(i) == value){
                    return true;
                }
            }
            return false;
        }

        public static int[] findTwoDime(int[][] arr , int val){
            for(int row = 0 ; row < arr.length ; row++){
                for(int col = 0 ; col < arr[row].length ; col++){
                    if(arr[row][col] == val ){
                        return new int[] {row,col};
                    }
                }
            }
            return new int[0];
        }

        public static void main(String args[]){

            int[] array = {1,2,3,4,5,6,7,8,9,10};
            String arrOfCharacters = "suthan raja";

            int [][] twoDimeArr = {
                {1,2,3},
                {4,5,6 , 8 , 0},
                {7,8,9}
            };

            long startTime = System.nanoTime();
            int index = LinearSearchAlgorithm.findIndex(array, 9);
            long endTime = System.nanoTime();



            System.out.println("Linear Search Index : " + index);

            System.out.println("Execution Time Index : " + (endTime - startTime) + " nanoseconds");

            System.out.println("Linear Search Contains : "+LinearSearchAlgorithm.findAndCheck(array , 2));

            System.out.println("Linear search string : "+LinearSearchAlgorithm.findString(arrOfCharacters, 'r'));

            System.out.println("Linear Two Di : "+ Arrays.toString(LinearSearchAlgorithm.findTwoDime(twoDimeArr , 0)));
        }
        
}
