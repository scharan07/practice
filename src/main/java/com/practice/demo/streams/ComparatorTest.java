package com.practice.demo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
    public static void main(String[] args) {
        /*
        Sort by name (in ascending order).
        If two employees have the same name, sort them by age (in ascending order).
        If two employees have the same name and age, sort them by salary (in descending order).
         */
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30, 50000));
        employees.add(new Employee("Alice", 25, 60000));
        employees.add(new Employee("John", 25, 55000));
        employees.add(new Employee("Bob", 35, 45000));
        employees.add(new Employee("Alice", 25, 55000));
        // method 1 directly on collection itself
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println(employees);
        //method 2 streams, sorted() methods works on primitive types & string, for custom objects use below
        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(list);

        //If two employees have the same name and age, sort them by salary (in descending order).
        employees.sort(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getSalary, Comparator.reverseOrder()));
        System.out.println(employees);

        System.out.println(employees.stream().sorted((o1, o2) -> (int)(o2.getSalary() - o1.getSalary())).limit(3)
                .collect(Collectors.toList()));
        System.out.println(employees.stream().sorted((o1, o2) -> (int)(o2.getSalary() - o1.getSalary())).skip(3)
                .collect(Collectors.toList()));
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList()));
    }
}

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}