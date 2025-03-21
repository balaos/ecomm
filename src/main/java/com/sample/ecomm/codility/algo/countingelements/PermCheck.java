package com.sample.ecomm.codility.algo.countingelements;

import java.util.HashSet;

public class PermCheck {
    public static int solution(int[] A) {
        int N = A.length;
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : A) {
            if (num < 1 || num > N || seenNumbers.contains(num)) {
                return 0; // Out of range or duplicate found
            }
            seenNumbers.add(num);
        }

        return 1; // All numbers from 1 to N found exactly once
    }

    public static void main(String[] args) {
        PermCheck solution = new PermCheck();
        System.out.println(solution(new int[]{4, 1, 3, 2})); // Output: 1
        System.out.println(solution(new int[]{4, 1, 3})); // Output: 0
    }
}
