package com.example.binarysearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;

@RestController
@RequestMapping("/api/binary-search")
public class BinarySearchController {

    @Autowired
    private BinarySearchService binarySearchService;

    @PostMapping("/search")
    public BinarySearchResponse binarySearch(@RequestBody int[] inputArray, @RequestParam int target) {
        String result = binarySearchService.performBinarySearch(inputArray, target);
        return new BinarySearchResponse(result, inputArray, target);
    }

    static class BinarySearchResponse {
        private final String message;
        private final int[] originalArray;
        private final int target;
        private final int[] sortedArray;
        private final int iterations;

        public BinarySearchResponse(String message, int[] originalArray, int target) {
            this.message = message;
            this.originalArray = originalArray;
            this.target = target;
            this.sortedArray = Arrays.copyOf(originalArray, originalArray.length);
            Arrays.sort(this.sortedArray);
            this.iterations = calculateIterations(originalArray, target);
        }

        // getters
        public String getMessage() {
            return message;
        }

        public int[] getOriginalArray() {
            return originalArray;
        }

        public int[] getSortedArray() {
            return sortedArray;
        }

        public int getIterations() {
            return iterations;
        }

        private int calculateIterations(int[] array, int target) {
            int iterations = 0;
            int left = 0;
            int right = array.length - 1;
            while (left <= right) {
                iterations++;
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return iterations; // Found the target
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return iterations; // Not found
        }
    }
}
