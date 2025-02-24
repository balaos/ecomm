package com.sample.ecomm.others.collection;

import java.util.*;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Alice", 50000));
        list.add(new Employee(2, "Bob", 60000));
        list.add(new Employee(3, "Charlie", 40000));

        // Sorting by Name using Java 8 Lambda
        list.sort(Comparator.comparing(e -> e.name));
        System.out.println("Sorted by Name: " + list);

        // Sorting by Salary in Descending Order
        list.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.println("Sorted by Salary (Descending): " + list);
    }
}
