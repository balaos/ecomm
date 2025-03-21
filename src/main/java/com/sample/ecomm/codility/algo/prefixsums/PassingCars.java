package com.sample.ecomm.codility.algo.prefixsums;

public class PassingCars {
    public int solution(int[] A) {
        int eastCars = 0;  // Count of cars traveling east (0s)
        int passingCars = 0; // Total count of passing cars

        for (int car : A) {
            if (car == 0) {
                eastCars++;  // Count eastbound car
            } else { // car == 1
                passingCars += eastCars; // Each westbound car pairs with all previous eastbound cars
                if (passingCars > 1_000_000_000) {
                    return -1; // Limit exceeded
                }
            }
        }

        return passingCars;
    }

    public static void main(String[] args) {
        PassingCars solution = new PassingCars();
        System.out.println(solution.solution(new int[]{0, 1, 0, 1, 1})); // Output: 5
    }
}
