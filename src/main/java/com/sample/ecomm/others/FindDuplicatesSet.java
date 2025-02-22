package com.sample.ecomm.others;

import java.util.HashSet;

public class FindDuplicatesSet {
    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicate elements: " + duplicates);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 5, 8, 6};
        findDuplicates(arr);
    }
}
