package com.practice.demo;

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        MultiplyFunctional multiply = (a, b) -> a*b;
        System.out.println(multiply.multiply(10,3));
    }
}

@FunctionalInterface
interface MultiplyFunctional {
    int multiply(int a, int b);
}
