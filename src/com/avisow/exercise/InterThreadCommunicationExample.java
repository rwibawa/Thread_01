package com.avisow.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rwibawa on 2/13/2016.
 */
public class InterThreadCommunicationExample {
    public void execute() {
        final Queue<Integer> sharedQueue = new LinkedList<Integer>();

        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();
    }
}
