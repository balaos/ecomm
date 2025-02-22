package com.sample.ecomm.others;

import java.util.HashMap;
import java.util.Map;

public class StringOps {
    public static void main(String[] args) {
        System.out.println(removeWhiteSpaces("Bala Murugan"));
        distinctCharCount();
    }

    public static String removeWhiteSpaces(String input) {
        StringBuilder output = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c))
                output.append(c);
        }

        return output.toString();
    }

    public static void distinctCharCount() {
        String str1 = "abcdABCDabcd";

        char[] chars = str1.toCharArray();

        Map<Character, Integer> charsCount = new HashMap<>();

        for (char c : chars) {
            if (charsCount.containsKey(c)) {
                charsCount.put(c, charsCount.get(c) + 1);
            } else
                charsCount.put(c, 1);
        }

        System.out.println(charsCount); // {a=2, A=1, b=2, B=1, c=2, C=1, d=2, D=1}
    }
}
