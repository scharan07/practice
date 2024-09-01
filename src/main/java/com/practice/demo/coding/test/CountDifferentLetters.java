package com.practice.demo.coding.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Duestche bank
 *  Problem Statement:
 * You are given a string letters made of N English letters.Count the number of different letters
 * that appear in both uppercase and lowercase where all lowercase occurrences of the given letter
 * appear before any uppercase occurrence.
 * For example, for letters = "aaAbcCABBc" the answer is 2.The condition is met for letters a and b,
 * but not letter c.
 *
 * Examples:
 *
 * Given letters = "aaAbcCABBc", the function should return 2, as explained above.
 * Given letters = "xyzXYZabcABC", the function should return 6.
 * Given letters = "ABCabcAefg", the function should return 0.
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * The string letters is made only of English letters (a-z and/or A-Z).
 *
 */
public class CountDifferentLetters {

    public static void main(String[] args) {
        CountDifferentLetters sol = new CountDifferentLetters();
        System.out.println(sol.countValidLetters("aAbBcCDdEeFf"));
    }

    public int countValidLetters(String letters) {
        List<Character> list = new ArrayList<>();
        int count = 0;

        for (char c : letters.toCharArray()) {
            if (Character.isLowerCase(c) && !list.contains(c)) {
                list.add(c);
                int uIndex = letters.indexOf(Character.toUpperCase(c)); // get index of next occurrence of uppercase
                int lIndex = letters.indexOf(c, uIndex); // get index of next occurrence of lowercase
                // if found uppercase and no lowercase after uppercase, count that has valid
                if (uIndex > -1 && lIndex == -1) count++;
            }
        }
        return count;
    }

    public int countValidLettersAI(String letters) {
        HashMap<Character, Integer> firstOccurrence = new HashMap<>();
        HashSet<Character> validLetters = new HashSet<>();

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            if (!firstOccurrence.containsKey(ch)) {
                firstOccurrence.put(ch, i);
            }
        }

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            if (Character.isLowerCase(ch)) {
                char upperCh = Character.toUpperCase(ch);
                if (firstOccurrence.containsKey(upperCh) && firstOccurrence.get(upperCh) > i) {
                    validLetters.add(ch);
                }
            }
        }

        return validLetters.size();
    }
}