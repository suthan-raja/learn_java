package msp.test.learn.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){

        if(arr.length <= 1) return arr;

        int mid = arr.length/2;

        int left[] = Arrays.copyOfRange(arr , 0 , mid);

        int right[] = Arrays.copyOfRange(arr, mid , arr.length);

        return merge(mergeSort(left) , mergeSort(right));

    }

    public static int[] merge(int[] left, int[] right){

        int joinedArray[] = new int[left.length + right.length];

        int i = 0 , j = 0 , k = 0 ;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                joinedArray[k++] = left[i++];
            }else{
                joinedArray[k++] = right[j++];
            }
        }


        while( i < left.length){
            joinedArray[k++] = left[i++];
        }

        while(j < right.length){
            joinedArray[k++] = right[j++];
        }

        return joinedArray;

    }

    public static void main(String[] args){

        int[] arr = {12,5,9,28,100,24};

        int[] val = mergeSort(arr);

        System.out.println("Sorted Array : " + Arrays.toString(val));

    }

}
