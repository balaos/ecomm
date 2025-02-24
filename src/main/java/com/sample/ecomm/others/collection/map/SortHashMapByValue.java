package com.sample.ecomm.others.collection.map;

import java.util.*;
import java.util.stream.*;

public class SortHashMapByValue {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Apple");
        map.put(1, "Orange");
        map.put(2, "Banana");

        // Convert HashMap to List and sort by value
        LinkedHashMap<Integer, String> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // Sorting by Value
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, // Key-Value mapping
                        (oldValue, newValue) -> oldValue, // Merge function
                        LinkedHashMap::new)); // Preserve order

        System.out.println("Sorted by Value: " + sortedMap);


        LinkedHashMap<Integer, String> sortedDesc = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Descending Order
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        System.out.println("Sorted by Value (Descending): " + sortedDesc);

    }
}
