package com.practice.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTest {
    public static void main(String[] args) {
        /**
         * below example created one Custom Object,
         * edited name and added twice to map.
         * Map check hashcode while insert that it is different
         * so inserts same object 2 different keys
         */
        Map<Custom, Integer> check = new HashMap<>();
        Custom custom = new Custom();
        custom.setName("Test");
        check.put(custom, 1); //add to map
        //edit name
        custom.setName(" scenario");
        check.put(custom, 2); //add another time
        System.out.println(check);
        System.out.println(check.get(custom));
    }
}

class Custom {
    private String name;

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Custom)) return false;

        Custom c = (Custom) obj;
        return super.equals(c.getName());
    }
}
