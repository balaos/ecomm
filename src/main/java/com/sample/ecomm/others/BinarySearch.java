package com.sample.ecomm.others;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 2, 1, 8, 22, 31, 40};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 0, arr.length, 40));
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return -1;

    }
}
