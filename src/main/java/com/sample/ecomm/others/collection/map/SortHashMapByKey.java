package com.sample.ecomm.others.collection.map;

import java.util.*;

public class SortHashMapByKey {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Apple");
        map.put(1, "Orange");
        map.put(2, "Banana");

        // Convert HashMap to TreeMap (Sorted by Key)
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);

        System.out.println("Sorted by Key: " + sortedMap);
    }
}
