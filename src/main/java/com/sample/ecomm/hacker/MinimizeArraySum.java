package com.sample.ecomm.hacker;

import java.util.*;

public class MinimizeArraySum {
    public static int minimizeSum(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to max heap
        for (int num : arr) {
            maxHeap.add(num);
        }

        // Perform k operations
        while (k-- > 0) {
            int maxElement = maxHeap.poll(); // Extract the max element
            int reducedValue = (int) Math.ceil(maxElement / 2.0); // Divide by 2 and take ceiling
            maxHeap.add(reducedValue); // Insert back into heap
        }

        // Compute the final sum
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 7};
        int k = 4;
        System.out.println("Minimized Sum: " + minimizeSum(arr, k));
    }
}
