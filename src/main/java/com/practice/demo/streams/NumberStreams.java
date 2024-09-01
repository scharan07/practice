package com.practice.demo.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 9, 5, 8, 2, 2, 3);
        //cube
        System.out.println("Cube " + list.stream().map(i -> i * i * i).collect(Collectors.toList()));
        //sum
        System.out.println("Sum " + list.stream().mapToInt(Integer::valueOf).sum());
        //avg
        System.out.println("Avg " + list.stream().mapToInt(Integer::intValue).average());
        //max
        list.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
        //min
        System.out.println("Min " + list.stream().mapToInt(Integer::intValue).min());
        //distinct
        System.out.println("distinct " + list.stream().distinct().collect(Collectors.toList()));

        //Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        List<Integer> test = List.of(40, 33, 34, 23,456, 456,787,234,236,85,235,7989 , 123, 156, 156);
        List<Integer> answer = test.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(answer);
        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        test.stream().map(String::valueOf).filter(i -> i.startsWith("1")).forEach(System.out::println);
        //How to find duplicate elements in a given integers list in java using Stream functions?
        test.stream().filter(c -> Collections.frequency(test, c) > 1).forEach(System.out::println);
        Optional<Integer> first = test.stream().findFirst();
        first.ifPresent(System.out::println);
        //Given a list of integers, find the total number of elements present in the list using Stream functions?
        long count = test.stream().count();
        System.out.println("Total elements are " + count);
        //Given a list of integers, find the maximum value element present in it using Stream functions?
        test.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
        //Given a list of integers, sort all the values present in it using Stream functions?
        test.stream().sorted().forEach(System.out::println);
        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        test.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        //integer array, return true if any value appears at least twice in the array, and return false if every element is distinct.
        Set<Integer> set = new HashSet<>(test);
        if (test.size() == set.size()) System.out.println("Yes test list has duplicates");

        List<Integer> integers = List.of(1, 2, 2, 3, 3, 4, 5, 5, 5, 6, 7, 7);
        integers.stream().mapToInt(Integer::valueOf).filter(i -> Collections.frequency(integers, i) == 1).max().ifPresent(System.out::println);
        //max occurance of a number
        integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.println(e.getKey()));
    }
}
class Solution {
    public int solution(int A, int B) {
        // Calculate the GCD of A and B
        int gcd = calculateGCD(A, B);

        // Calculate the side length of the square
        int sideLength = gcd / 4;

        return sideLength;
    }

    // Helper function to find the GCD using Euclidean algorithm
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}