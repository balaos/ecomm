package com.sample.ecomm.hacker;

import java.util.*;

public class MaxDifferenceCouple {
    public static int maxDifference(int[] arr) {
        int n = arr.length;
        if (n <= 8) return -1; // Ensuring the array has more than 8 elements

        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            selected.add(arr[i]);
        }

        Collections.sort(selected, Collections.reverseOrder()); // Sort in descending order

        int maxDiff = Integer.MIN_VALUE;
        int len = selected.size();

        // Try all possible non-consecutive picks
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 2; j < len - 2; j++) {
                for (int k = j + 2; k < len - 1; k++) {
                    for (int l = k + 2; l < len; l++) {
                        int product1 = selected.get(i) * selected.get(j);
                        int product2 = selected.get(k) * selected.get(l);
                        maxDiff = Math.max(maxDiff, Math.abs(product1 - product2));
                    }
                }
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Maximum Difference: " + maxDifference(arr));
    }
}
