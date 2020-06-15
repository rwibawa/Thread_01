package com.avisow.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor02 {
    public void execute() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
            () -> "task1",
            () -> "task2",
            () -> "task3");

        executor.invokeAll(callables)
        .stream()
        .map(future -> {
            try {
                return future.get(1, TimeUnit.SECONDS); // timeout in 1 sec if the result is not available
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        })
        .forEach(System.out::println);
    }
}
