package com.practice.demo.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeTest {
    public static void main(String[] args) {
        //How will you get the current date and time using Java 8 Date and Time API?
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.now(); //default
        ZonedDateTime est = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.format("Local date %s Local date time %s\n" +
                "Defualt ZonedDateTime %s EST ZonedDate %s", ld, ldt, zdt, est);
    }
}
