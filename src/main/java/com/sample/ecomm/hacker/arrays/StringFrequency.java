package com.sample.ecomm.hacker.arrays;

import java.util.*;

public class StringFrequency {
    public static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each string in the input list
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Get occurrences for each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = frequencyMap.getOrDefault(queries[i], 0);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of input strings
        sc.nextLine(); // Consume newline
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }

        int q = sc.nextInt(); // Number of queries
        sc.nextLine(); // Consume newline
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextLine();
        }

        int[] result = matchingStrings(strings, queries);

        for (int count : result) {
            System.out.println(count);
        }

        sc.close();
    }
}
