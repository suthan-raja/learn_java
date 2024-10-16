package msp.test.learn.algorithm.search;

public class BinarySearchAlgorithm {

    public static int binarySearch(int[] arr , int target){
       int left = 0;
       int right = arr.length - 1;
       while(left <= right){
           int mid = left + ( right - left)/2; // 3

           if(arr[mid] == target){ // 4
               return mid;
           }

           if(target > arr[mid]){
               left = mid + 1;
           }else{
               right = mid - 1;
           }
       }

       return -1;

    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7};
        int target = 7;
        System.out.println(binarySearch(arr , target));
    }
}
