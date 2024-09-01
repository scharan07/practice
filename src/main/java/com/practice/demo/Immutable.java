package com.practice.demo;

public class Immutable {

}

/**
 * Immutable Class
 * 1. final class
 * 2. final methods, must be initialized in constructor
 * 3. no setter methods for members
 */
final class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
