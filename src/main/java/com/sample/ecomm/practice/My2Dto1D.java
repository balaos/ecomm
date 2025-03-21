package com.sample.ecomm.practice;

import java.util.Arrays;

public class My2Dto1D {

    public static int[] sort (int[][] matrix) {
        int n = matrix.length;
        int[] arr = new int[n*n];
        int index = 0;
        for (int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < n ; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        return arr;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {12, 22, 32, 42},
                {15, 25,35, 45},
                {17, 27, 37, 47}
        };

        System.out.println("sorted : "+ Arrays.toString(sort(arr)));
    }
}
