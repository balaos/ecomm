package com.sample.ecomm.codility.algo;

import java.util.*;

class StringTransformer {
    public String solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // Remove adjacent pairs "AA", "BB", "CC"
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringTransformer transformer = new StringTransformer();
        System.out.println(transformer.solution("ACCAABBC")); // Output: "AC"
    }
}
