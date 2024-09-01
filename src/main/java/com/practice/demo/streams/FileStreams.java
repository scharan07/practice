package com.practice.demo.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStreams {
    public static void main(String[] args) throws IOException {

        // read file to streams
        Stream<String> lines = Files.lines(Paths.get("Test.txt")).map(String::trim);
        System.out.println(  Files.lines(Paths.get("Test.txt")).map(String::trim).collect(Collectors.joining(" ")));

        Map<String, Long> newLines = Files.lines(Paths.get("Test.txt")) // read file
                .flatMap(line -> Arrays.stream(line.trim().split(" "))) // conevert multiple lines to a string
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())); // each word count

        System.out.println(newLines);

        BufferedReader br = Files.newBufferedReader(Path.of("Test.txt"));
        br.lines().forEach(System.out::println);
        List<String> allLines = Files.readAllLines(Path.of("Test.txt"));
        allLines.stream().forEach(System.out::print);
        // don't need to write catch or finally for try-with-resource
        // try-with-resource can be used on all AutoCloseable interface classes.
        try (BufferedReader br1 = Files.newBufferedReader(Path.of("Test.txt"))) {
            br1.lines().forEach(System.out::println);
        }
    }
}

