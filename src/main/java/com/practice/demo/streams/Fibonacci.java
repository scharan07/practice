package com.practice.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 15;
        List<Integer> list = fibonacciUsingStreams(n);
        list.forEach(System.out::println);

        System.out.println("Recussive First " + n + " Fibonacci numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     *
     * @param n number of integers to generate
     *
     * @return list of n fibonacci numbers
     */
    private static List<Integer> fibonacciUsingStreams(int n) {
        List<Integer> list = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(n)
                .map(f -> f[0])
                .toList();
        return list;
    }

    // Recursive method to calculate Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
