package com.sample.ecomm.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMaxDiff {

    public static int maxDifference (int[] arr) {
        if (arr.length <= 8 ) return -1;
        int maxDiff = Integer.MIN_VALUE;
        List<Integer> arrList = new ArrayList<>();
        for (int x : arr) {
            arrList.add(x);
        }

        Collections.sort(arrList, Collections.reverseOrder());

        int len = arrList.size();

        for ( int i = 0 ; i < len - 3; i++) {
            for ( int j = i+2 ; j < len - 2; j++) {
                for ( int k = j+2 ; k < len - 1; k++) {
                    for ( int l = k+2 ; l < len; l++) {
                        int product1 = arrList.get(i) * arrList.get(j);
                        int product2 = arrList.get(k) * arrList.get(l);
                        System.out.println(i +","+j+","+k+","+l);
                        maxDiff = Math.max(maxDiff , Math.abs(product1 - product2));
                    }
                }
            }
        }



        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Maximum Difference: " + maxDifference(arr));
    }

}
