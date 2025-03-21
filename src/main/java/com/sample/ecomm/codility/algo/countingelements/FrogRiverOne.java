package com.sample.ecomm.codility.algo.countingelements;
import java.util.HashSet;
public class FrogRiverOne {
    public int solution(int X, int[] A) {
        HashSet<Integer> positions = new HashSet<>();

        for (int time = 0; time < A.length; time++) {
            positions.add(A[time]); // Add leaf position

            if (positions.size() == X) { // All positions covered
                return time;
            }
        }

        return -1; // Frog cannot cross
    }

    public static void main(String[] args) {
        FrogRiverOne solution = new FrogRiverOne();
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution.solution(X, A)); // Output: 6
    }
}
