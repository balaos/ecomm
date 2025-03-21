package com.sample.ecomm.hacker.arrays;

import java.util.*;

public class LeftRotation {
    public static int[] rotateLeft(int[] arr, int d) {
        int n = arr.length;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[i] = arr[(i + d) % n];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Array size
        int d = sc.nextInt(); // Number of left rotations
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = rotateLeft(arr, d);

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}

