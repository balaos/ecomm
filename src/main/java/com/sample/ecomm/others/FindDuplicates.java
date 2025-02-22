package com.sample.ecomm.others;

public class FindDuplicates {
    public static void findDuplicates(int[] arr) {
        System.out.print("Duplicate elements: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    break; // Avoid printing multiple times
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 5, 8, 6};
        findDuplicates(arr);
    }
}
