package com.sample.ecomm.codility.algo.stackqueue;

import java.util.*;

public class Fish {
    public static int solution(int[] A, int[] B) {
        Stack<Integer> downstream = new Stack<>();
        int alive = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                // Downstream fish, push onto stack
                downstream.push(A[i]);
            } else {
                // Upstream fish, fight with downstream fish
                while (!downstream.isEmpty()) {
                    if (downstream.peek() > A[i]) {
                        // Downstream fish survives, upstream fish dies
                        break;
                    } else {
                        // Downstream fish dies, pop and continue
                        downstream.pop();
                    }
                }
                // If no downstream fish remain, this fish survives
                if (downstream.isEmpty()) {
                    alive++;
                }
            }
        }

        // Surviving downstream fish
        return alive + downstream.size();
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 3, 2, 1, 5};
        int[] B = new int[]{0, 1, 0, 0, 0};
        System.out.println(solution(A, B));
    }
}
