package com.sample.ecomm.codility.algo.arrays;

import java.util.*;

public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the unpaired element
        for (int num : A) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1; // Should never reach here
    }

    public static int solution2(int[] A) {
        int unpaired = 0;
        for (int num : A) {
            unpaired ^= num; // XOR all numbers
        }
        return unpaired;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }
}
