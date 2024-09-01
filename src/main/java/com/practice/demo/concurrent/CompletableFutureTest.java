package com.practice.demo.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public void check() {
        CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Hello World!");

        CompletableFuture<Integer> nameLength = name.thenApply(value -> {
            printCurrentThread(); // will print "main"
            return value.length();
        });

    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }
}
