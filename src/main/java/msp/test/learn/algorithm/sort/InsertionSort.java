package msp.test.learn.algorithm.sort;

public class InsertionSort {

    public static int[] insertionSort(int[] arr){
        int n = arr.length;

//        64,34,25,12,22 -- 34,64,25,12,22 -- 25,34,64,12,22

        for(int i = 1 ; i < n ; i++){ // 2
            int val = arr[i]; // 34 25
            int j = i - 1;  // 0 1
            while(j >= 0 && arr[j] > val){  // 64 > 34  64 > 25 34 > 25
                arr[j+1] = arr[j]; // 1 -> 64 2 -> 64 1 -> 34
                j = j - 1; // -1 0 -1
            }

            arr[j+1] = val; // -1+1 = 0 0 -> 34 0 -> 25
        }

        return arr;
    }

    public static void main(String[] args) {

        int array[] = {64,34,25,12,22};

    }

}
