package com.sample.ecomm.others.collection;

import lombok.Data;

import java.util.*;

@Data
class Employee implements Comparable<Employee> {
    public int id;
    public String name;
    public double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Implementing compareTo() for Natural Sorting (Sorting by Salary)
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary); // Ascending order
    }

    @Override
    public String toString() {
        return id + " - " + name + " - $" + salary;
    }

}

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Alice", 50000));
        list.add(new Employee(2, "Bob", 60000));
        list.add(new Employee(3, "Charlie", 40000));

        Collections.sort(list); // Uses compareTo()

        System.out.println("Sorted Employees (By Salary):");
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}
