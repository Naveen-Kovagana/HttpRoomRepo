package com.example.binarysearchpractice.BinarySearch;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BinarySearchService{

    public String performBinarySearch(int[] inputArray, int target) {

        //step-1: sort the array
        int[] sortedArray = inputArray.clone();
        Arrays.sort(sortedArray);

        //step-2: perform binary search
        int left = 0, right = sortedArray.length - 1;
        int iterations = 0;
        int targetindex = -1;
        while (left <= right) {
            iterations++;
            int mid = left + (right - left) / 2;
            if(sortedArray[mid] == target) {
                targetindex = mid;
                break;
            }else if(sortedArray[mid] < target) {
                left = mid + 1;
            }else{ right = mid - 1;}

        }

        if(targetindex != -1) {
            return "Element found at index " + targetindex + " in array. Iterations : " + iterations;
        }
        else{
            return "Element not found in array. Iterations : " + iterations;
        }

    }

}
