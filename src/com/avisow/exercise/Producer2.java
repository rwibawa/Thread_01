package com.avisow.exercise;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class Producer2 implements Runnable {
    private final BlockingQueue<Integer> sharedQ;

    public Producer2(BlockingQueue<Integer> sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQ.put(i);
            } catch (Exception e) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
