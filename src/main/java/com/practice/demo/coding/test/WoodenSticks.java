package com.practice.demo.coding.test;

/**
 * Duestche bank and Apple
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
