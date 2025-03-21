package com.sample.ecomm.codility.algo.stackqueue;

import java.util.Stack;

public class Stonewall {
    public static int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop(); // Remove taller blocks
            }

            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height); // Add new block
                blocks++;
            }
        }

        return blocks;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(solution(arr));
    }
}
