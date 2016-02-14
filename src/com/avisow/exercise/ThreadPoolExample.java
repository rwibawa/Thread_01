package com.avisow.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class ThreadPoolExample {
    public void execute() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(i));
        }
    }

    private class Task implements Runnable {
        private final int taskId;

        public Task(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Task ID : " + this.taskId + " performed by "
                    + Thread.currentThread().getName());
        }
    }
}
