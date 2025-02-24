package com.sample.ecomm.others.collection.set;

import java.util.TreeSet;

public class TreeSetNavigableExample {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        System.out.println("Original Set: " + set); // [10, 20, 30, 40, 50]
        System.out.println("First Element: " + set.first()); // 10
        System.out.println("Last Element: " + set.last()); // 50
        System.out.println("Higher than 30: " + set.higher(30)); // 40
        System.out.println("Lower than 30: " + set.lower(30)); // 20
        System.out.println("Ceiling (≥25): " + set.ceiling(25)); // 30
        System.out.println("Floor (≤25): " + set.floor(25)); // 20
        System.out.println("Descending Set: " + set.descendingSet()); // [50, 40, 30, 20, 10]
    }
}
