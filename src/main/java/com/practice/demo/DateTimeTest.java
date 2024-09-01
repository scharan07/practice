package com.practice.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate d1= LocalDate.of(2024, 05, 13);
        LocalDate.parse("2024-05-13");

        LocalDateTime.now();
       // LocalDateTime.of(10, 19, 36);
        LocalDateTime.parse("10:19:36");
        long between = ChronoUnit.MINUTES.between(now, d1);
        System.out.println(between);
    }
}
