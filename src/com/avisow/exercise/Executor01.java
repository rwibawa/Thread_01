package com.avisow.exercise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Executor01 {
    public void execute() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a task
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        // => Hello pool-1-thread-1

        // Submit a task that returns a String
        Future<String> str1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "done";
        });

        System.out.println(str1.get());

        // Stop the executor
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }

            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
