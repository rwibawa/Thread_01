package com.avisow.exercise;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Executor04 {
    public void execute() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> System.out.println("Delayed Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task1, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms\n", remainingDelay);

        // Periodic task every 1 second
        Runnable task2 = () -> System.out.println("Periodic Scheduling: " + System.nanoTime());
        long period = 1;
        long initialDelay = 0;
//        executor.scheduleAtFixedRate(task2, initialDelay, period, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(task2, initialDelay, period, TimeUnit.SECONDS);
    }
}
