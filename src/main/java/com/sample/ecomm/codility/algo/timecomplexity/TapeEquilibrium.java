package com.sample.ecomm.codility.algo.timecomplexity;

public class TapeEquilibrium {
    public static int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        int minDifference = Integer.MAX_VALUE;

        for (int P = 0; P < A.length - 1; P++) {
            leftSum += A[P];
            int rightSum = totalSum - leftSum;
            int difference = Math.abs(leftSum - rightSum);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 2, 4, 3};
        System.out.println(solution(arr));
    }
}
