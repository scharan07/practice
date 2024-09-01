package com.practice.demo.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreams {
    public static void main(String[] args) {
        String words = "testing something for java and searching for java in java to now it is java";

        // search for word "java"
        // Java streams default return type is long (not integer), here Collectors.counting() returns long
        // string has to converted to array to make stream
        Map<String, Long> collect = Arrays.stream(words.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Function.identity() simply returns its input argument, essentially acting as an identity function.
        //In other words, whatever value is passed into it, the same value is returned without any alteration
        System.out.println(collect);

        //2. check for letters and its count
        System.out.println(
                words.chars() // chars() return IntStream not char stream, there is no CharStream in java
                        .mapToObj(c -> Character.toLowerCase( (char) c))// convert int to char and lowercase
                        .sorted()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        // 3. search for vowels in the string
        Map<Character, Long> vowelsCount = words.chars().
                mapToObj(c -> (char) Character.toLowerCase(c))
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(vowelsCount);

        //Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java articles are Awesome";
        input.chars().mapToObj(c -> (char) Character.toLowerCase(c)).distinct().findFirst().ifPresent(System.out::println);

        //How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                .stream()
                .filter(x->Collections.frequency(names, x)>1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        
        List<Notes> noteLst = List.of(new Notes("tag1"),
                new Notes("tag2"),
                new Notes("tag3"));
        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(note -> note.getTagName()) // method reference, consider only tag name
                .forEach(System.out::println); // it
    }
}

class Notes {
    private String tagName;
    public Notes(String tagName) {
        this.tagName = tagName;
    }
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
