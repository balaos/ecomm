package com.sample.ecomm.codility.algo.stackqueue;

import java.util.*;

public class Brackets {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);  // Push opening brackets
            } else {
                if (stack.isEmpty()) return 0;  // No matching opening bracket

                char top = stack.pop();  // Pop last opened bracket

                // Check if brackets match
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return 0;  // Mismatched closing bracket
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;  // Stack must be empty for a valid nesting
    }

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
    }
}
