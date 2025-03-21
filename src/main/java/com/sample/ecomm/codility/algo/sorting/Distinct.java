package com.sample.ecomm.codility.algo.sorting;

import java.util.*;

public class Distinct {
    public int solution(int[] A) {
        Set<Integer> uniqueValues = new HashSet<>();

        for (int num : A) {
            uniqueValues.add(num); // HashSet ensures uniqueness
        }

        return uniqueValues.size(); // Number of distinct values
    }

    public static void main(String[] args) {
        Distinct solution = new Distinct();
        System.out.println(solution.solution(new int[]{2, 1, 1, 2, 3, 1})); // Output: 3
    }
}
