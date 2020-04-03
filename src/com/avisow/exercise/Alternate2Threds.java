package com.avisow.exercise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

// Thread 1 -> 1,3,5, ... , 99
// Thread 2 -> 2,4,6, ... , 100

// Output: 1, 2, 3, 4, 5, ... , 100
public class Alternate2Threds {
    final CyclicBarrier cb = new CyclicBarrier(2,
            () -> {
                // done
            }
    );

    public void execute() {
        Thread t1 = new Thread(new Task(cb,1), "Thread 1");
        Thread t2 = new Thread(new Task(cb,2), "Thread 2");

        t1.start();
        t2.start();
    }

    class Task implements Runnable {
        private CyclicBarrier barrier;
        private int startNumber;

        public Task(CyclicBarrier barrier, int startNumber) {
            this.barrier = barrier;
            this.startNumber = startNumber;
        }

        @Override
        public void run() {
            try {
                for (int i=startNumber; i <= 100; i=i+2) {
                    barrier.await();
                    System.out.print(i + " ");
                }
            } catch (InterruptedException e) {
                // e.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            } catch (BrokenBarrierException e) {
                //e.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
