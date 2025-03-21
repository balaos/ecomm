package com.sample.ecomm.hacker.arrays;

import java.util.*;

public class HourglassSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];

        // Input 6x6 array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int maxSum = Integer.MIN_VALUE;

        // Iterate over all possible hourglasses
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]   // Top row
                        + arr[i+1][j+1]                         // Middle element
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]; // Bottom row

                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);
    }
}
