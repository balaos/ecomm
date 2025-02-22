package com.sample.ecomm.others;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCounts {
    public static void findDuplicatesWithCount(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Print elements appearing more than once
        System.out.println("Element | Frequency");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("   " + entry.getKey() + "    |    " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 5, 8, 6, 5, 4};
        findDuplicatesWithCount(arr);
    }
}
