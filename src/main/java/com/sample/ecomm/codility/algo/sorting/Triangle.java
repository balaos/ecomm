package com.sample.ecomm.codility.algo.sorting;

import java.util.*;

public class Triangle {
    public int solution(int[] A) {
        if (A.length < 3) return 0;  // A triangle needs at least 3 elements

        Arrays.sort(A);  // Sort the array

        for (int i = 0; i < A.length - 2; i++) {
            // Check if A[i] + A[i+1] > A[i+2] (other conditions are implied)
            if ((long)A[i] + A[i+1] > A[i+2]) {
                return 1;  // Triangular triplet found
            }
        }
        return 0;  // No valid triplet found
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 5, 1, 8, 20};
        Triangle triangle = new Triangle();
        System.out.println(triangle.solution(arr));
    }
}
