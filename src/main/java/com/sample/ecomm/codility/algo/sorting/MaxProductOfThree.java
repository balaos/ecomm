package com.sample.ecomm.codility.algo.sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        // Step 1: Sort the array
        Arrays.sort(A);
        int N = A.length;

        // Step 2: Compute two possible max products
        int option1 = A[N - 1] * A[N - 2] * A[N - 3]; // Largest three numbers
        int option2 = A[0] * A[1] * A[N - 1];         // Two smallest numbers + largest number

        // Step 3: Return the maximum of both cases
        return Math.max(option1, option2);
    }

    public static void main(String[] args) {
        MaxProductOfThree solution = new MaxProductOfThree();
        System.out.println(solution.solution(new int[]{-3, 1, 2, -2, 5, 6})); // Output: 60
    }
}
