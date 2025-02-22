package com.sample.ecomm.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
        System.out.println(!onlyOddNumbers(List.of(5, 7, 3)));
        System.out.println(onlyOddNumbers1(List.of(5, 7, 3)));
        System.out.println(factorial(5));
        shuffle();
    }
    public static boolean onlyOddNumbers(List<Integer> list) {
        return list
                .parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 == 0); // return as soon as any elements match the condition
    }

    public static boolean onlyOddNumbers1(List<Integer> list) {
        for (int i : list) {
            if (i % 2 == 0)
                return false;
        }

        return true;
    }

    public static long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public static void shuffle() {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
