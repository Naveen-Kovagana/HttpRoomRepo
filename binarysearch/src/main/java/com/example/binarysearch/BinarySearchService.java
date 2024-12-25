package com.example.binarysearch;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BinarySearchService {

    public String performBinarySearch(int[] inputArray, int target){
        //step-1: Sort the array
        int[] sortedArray = inputArray.clone(); //Keep inputArray intact
        Arrays.sort(sortedArray);

        //step-2: Perform Binary Search
        int iterations = 0;
        int left = 0;
        int right = sortedArray.length - 1;
        int targetIndex = -1;

        while(left <= right){
            iterations++;
            int mid = left + (right - left) / 2;

            if(sortedArray[mid] == target){
                targetIndex = mid;
                break;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        //step-3: Return the result
        if(targetIndex != -1){
            return "Element found at index " + targetIndex+ " in sorted array. Iterations: "+iterations;
        }else {
            return "Element not found. Iterations: "+iterations;
        }
    }

}
