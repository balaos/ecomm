package com.sample.ecomm.hacker;

import java.util.*;

public class Sorted2DTo1D {
    public static int[] sort2DArray(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n * n];
        int index = 0;

        // Copy all elements from 2D array to 1D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[index++] = matrix[i][j];
            }
        }

        // Sort the 1D array
        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {4, 8, 10}
        };

        int[] sortedArray = sort2DArray(matrix);

        System.out.println("Sorted 1D Array: " + Arrays.toString(sortedArray));
    }
}

