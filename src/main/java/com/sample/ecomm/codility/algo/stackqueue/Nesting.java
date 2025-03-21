package com.sample.ecomm.codility.algo.stackqueue;

public class Nesting {

    public static int solution(String S) {
        int openCount = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else { // c == ')'
                if (openCount == 0) {
                    return 0; // Unmatched closing parenthesis
                }
                openCount--; // Match found
            }
        }

        return openCount == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()(())())"));
    }
}
