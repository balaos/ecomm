package com.sample.ecomm.others;

public class SecondLargestElement {
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return -1;
        }

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;  // Update second largest
                first = num;     // Update largest
            } else if (num > second && num != first) {
                second = num;  // Update second largest only if it's not equal to the largest
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 20, 30, 25};
        int secondLargest = findSecondLargest(arr);

        if (secondLargest != -1) {
            System.out.println("Second Largest Element: " + secondLargest);
        } else {
            System.out.println("No second largest element found.");
        }
    }
}

