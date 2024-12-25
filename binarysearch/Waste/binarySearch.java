package com.example.binarysearch;

import java.util.Arrays;

public class binarySearch {
    //Function to sort the array
    public int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    //Function to perform binary search
    public int binarySearch(int[] arr, int target){
        int left =0, right = arr.length-1, iterations = 0;
        while(left <= right){
            int middle = (left + (right - left))/2;
            iterations++;
            if(arr[middle] == target){
                System.out.println("Element found at index " + middle+" in "+iterations+" iterations");
                return middle;
            }
            if(arr[middle] < target){
                left = middle+1;
            }
            else{
                right = middle-1;
            }
        }
        System.out.println("Element not found after "+iterations+" iterations");
        return -1;
    }


}
