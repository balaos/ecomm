package com.sample.ecomm.others.collection;

import java.util.*;

class Employee1 {
    int id;
    String name;
    double salary;

    public Employee1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - $" + salary;
    }
}

// Comparator for sorting by Name
class NameComparator implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 e1, Employee1 e2) {
        return e1.name.compareTo(e2.name); // Ascending order (A-Z)
    }
}

// Comparator for sorting by Salary (Descending)
class SalaryComparator implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 e1, Employee1 e2) {
        return Double.compare(e2.salary, e1.salary); // Descending order
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee1> list = new ArrayList<>();
        list.add(new Employee1(1, "Alice", 50000));
        list.add(new Employee1(2, "Bob", 60000));
        list.add(new Employee1(3, "Charlie", 40000));

        // Sorting by Name
        Collections.sort(list, new NameComparator());
        System.out.println("Sorted by Name: " + list);

        // Sorting by Salary (Descending)
        Collections.sort(list, new SalaryComparator());
        System.out.println("Sorted by Salary (Descending): " + list);
    }
}
