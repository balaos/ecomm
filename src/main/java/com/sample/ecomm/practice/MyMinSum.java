package com.sample.ecomm.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class MyMinSum {

    public static int minSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val : arr) {
            pq.add(val);
        }

        while (k-- > 0 ) {
            int num = pq.poll();
            int x = (int) Math.ceil(num/2.0);
            pq.add(x);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 7};
        int k = 4;

        System.out.println(minSum(arr , 4));
    }
}
