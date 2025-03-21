package com.sample.ecomm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        findBigInArray();
        findSecondBigInArray();
        factorialDemo();
        fibonacciDemo();
        checkPalindrome();
        checkAnagram();
        reverseString();
        findDuplicate();
        findDuplicateUsingHashMap();
        swapNumbers();
        sortHashMapByValue();
        sortHashMapByKey();
        printPattern1(9);
        printPattern2(9);
        printPattern3(9);
        printPattern4(9);
        binarySearchDemo();
    }

    public static void findBigInArray() {
        int[] arr = {4, 8, 9, 1, 2};
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }


    public static void findSecondBigInArray() {
        int[] arr = {4, 8, 9, 1, 2, 10};
        int largest = Integer.MIN_VALUE;
        int secondBig = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] > largest) {
                secondBig = largest;
                largest = arr[i];
            } else if (arr[i] > secondBig && arr[i] != largest) {
                secondBig = arr[i];
            }

        }

        System.out.println("second big : "+secondBig);
    }

    public static void factorialDemo() {
       System.out.println("factorial: "+factorial(5));
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return (n * factorial(n-1));
    }

    public static void fibonacciDemo() {
        for ( int i =0 ; i < 10 ; i++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci (int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void checkPalindrome() {
        String str = "silent";
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            if (arr[left] != arr[right]) {
               System.out.println("Not Palindrome");
               break;
            }
            left++;
            right--;
        }
    }


    public static void checkAnagram() {
        String str1 = "silent";
        String str2 = "listen";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("isAnagram : "+Arrays.equals(arr1, arr2));
    }

    public static void reverseString() {
        String str1 = "silent";
        char[] arr1 = str1.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr1.length-1 ; i >=0 ; i--) {
            stringBuilder.append(arr1[i]);
        }
        System.out.println("reversed : "+stringBuilder.toString());
    }

    public static void findDuplicate() {
        int[] arr = {4, 8, 9, 1, 2, 10, 4, 2};
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate : "+ arr[i]);
                    break;
                }
            }
        }
    }

    public static void findDuplicateUsingHashMap() {
        int[] arr = {4, 8, 9, 1, 2, 10, 4, 2};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry :  map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("duplicate: "+entry.getKey()+"-->"+entry.getValue());
            }
        }
    }

    public static void swapNumbers () {
        int a = 10;
        int b = 20;

        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println("a : "+a+", b : "+b);
    }

    public static void sortHashMapByValue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "Apple");
        map.put(20, "Orange");
        map.put(30, "Banana");

        LinkedHashMap<Integer, String> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldvalue, newValue) -> oldvalue, LinkedHashMap::new));
        System.out.println(sortedMap);
    }

    public static void sortHashMapByKey() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "Apple");
        map.put(20, "Orange");
        map.put(30, "Banana");

        LinkedHashMap<Integer, String> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldvalue, newValue) -> oldvalue, LinkedHashMap::new));
        System.out.println(sortedMap);
    }

    public static void printPattern1(int rows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = rows-i; j >=1 ; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j<=i;j++) {
                System.out.print(i+" ");
            }
            System.out.println(" ");
        }
    }

    public static void printPattern2(int rows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = rows-i; j >=1 ; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j<=i;j++) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }

    public static void printPattern3(int rows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = rows-i; j >=1 ; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j<=i;j++) {
                System.out.print(j+" ");
            }

            for (int j = i-1; j>=1;j--) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }

    public static void printPattern4(int rows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = 1; j <=i-1; j++) {
                System.out.print(" ");
            }

            for (int j = rows-i; j>=0;j--) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    public static void binarySearchDemo() {
        int[] arr = {2, 4,8,1, 5, 9, 7};
        Arrays.sort(arr);
        System.out.println("arr : "+binarySearch(arr, 0, arr.length, 5));

    }

    public static int binarySearch(int[] arr, int low, int high, int toFind) {
        int mid = low+high / 2;

        while (low <= high) {
            if (arr[mid] == toFind) {
                return mid;
            } else if (arr[mid] > toFind) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low+high/2;
        }

        return -1;

    }
}
