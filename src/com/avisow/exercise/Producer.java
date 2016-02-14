package com.avisow.exercise;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class Producer extends Thread {
    private final Queue<Integer> sharedQ;
    private static final Logger logger = Logger.getLogger(Producer.class.getName());

    public Producer(Queue<Integer> sharedQueue) {
        super("Producer");
        this.sharedQ = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            synchronized (sharedQ) {
                // wait condition - wait until the queue is empty
                while (sharedQ.size() >= 1) {
                    try {
                        logger.log(Level.INFO, "Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        logger.log(Level.SEVERE, null, e);
                    }
                }

                logger.log(Level.INFO, "producing: " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}
