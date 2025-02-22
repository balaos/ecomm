package com.sample.ecomm.others;

public class PalindromeRecursion {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: if pointers meet or cross, it's a palindrome
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false; // Mismatch found
        }
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String input = "racecar";
        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}
