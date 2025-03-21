package com.sample.ecomm.codility.algo.timecomplexity;

public class PermMissingElem {

    public static int solution(int[] A) {
        int N = A.length;
        long expectedSum = (long) (N + 1) * (N + 2) / 2;
        long actualSum = 0;

        for (int num : A) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5};
        System.out.println(solution(arr));
    }
}
