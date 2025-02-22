package com.sample.ecomm.intr;

public class FunctionalIntrSample {
    public static void main(String[] args) {
        IWeight<Integer> weight = x -> x * 1000;
        System.out.println(weight.convert(1));

        IWeight<Double> weight1 = x -> x * 1000.00;
        System.out.println(weight.convert(1));

        //Runnable is an excellent example of a functional interface.
        //You can use lambda expressions to create a runnable, as shown in the following example code:
        Runnable r1 = () -> System.out.println("My Runnable");
    }

}
