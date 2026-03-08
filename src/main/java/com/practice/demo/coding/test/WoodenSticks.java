package com.practice.demo.coding.test;

/**
 * Duestche bank and Apple
 *There are two wooden sticks of lengths A and B respectively. Each of them can be cut into shorter sticks of integer lengths. Our goal is to construct the largest possible square. In order to do this, we want to cut the sticks in such a way as to achieve four sticks of the same length (note that there can be some leftover pieces). What is the longest side of square that we can achieve?

Write a function:

java
class Solution { public int solution(int A, int B); }
that, given two integers A, B, returns the side length of the largest square that we can obtain. If it is not possible to create any square, the function should return 0.

Examples:
Given A = 10, B = 21, the function should return 7. We can split the second stick into three sticks of length 7 and shorten the first stick by 3.

Given A = 13, B = 11, the function should return 5. We can cut two sticks of length 5 from each of the given sticks.

Given A = 2, B = 1, the function should return 0. It is not possible to make any square from the given sticks.

Given A = 1, B = 8, the function should return 2. We can cut stick B into four parts.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [1..1,000,000,000].
 */
public class WoodenSticks {
    public static void main(String[] args) {
        // A = 10, b = 21, answer = 7
        // A = 13, b = 11 answer = 5
        // A = 1, b = 8 answer = 2
        // A = 2, b = 1 answer = 0
        int a = 1;
        int b = 2;

        // sum both stick values and get the average length
        int len = (a + b) / 4;

        while (len > 0) {
            // get number of pieces will come out of each stick
            int aPieces = a/len;
            int bPieces = b/len;

            // sum of both will be equal 4 then we got length
            if (aPieces + bPieces == 4) {
                System.out.println(len);
                break;
            }
            // cannot make 4 pieces with above length, now check next lower value, will be repeated till we found
            len--;
        }
        System.out.println(len);
    }
}
