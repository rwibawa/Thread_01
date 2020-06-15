package com.avisow.exercise;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // write your code here
        System.out.println("Starting..");

//        CyclicBarrierExample program = new CyclicBarrierExample();
//        CountDownLatchDemo program = new CountDownLatchDemo();
        // InterThreadCommunicationExample program = new InterThreadCommunicationExample();
        // ThreadPoolExample program = new ThreadPoolExample();
//        ProducerConsumerPattern program = new ProducerConsumerPattern();
        // ThreadLocalTest program = new ThreadLocalTest();
//        AtomicIntegerExample program = new AtomicIntegerExample();
//        Deadlock program = new Deadlock();
//        CallableExample program = new CallableExample();
//        SemaphoreExample program = new SemaphoreExample();
//        Alternate2Threds program = new Alternate2Threds();
//        Executor01 program = new Executor01();
//        Executor02 program = new Executor02();
//        Executor03 program = new Executor03();
        Executor04 program = new Executor04();
        program.execute();

//        Singleton1 singleton1 = Singleton1.getInstance();
//        Singleton2 singleton2 = Singleton2.getInstance();


/*
        ImmutableContacts immutableObject = new ImmutableContacts("Ryan", "(555) 555-5555");
        LocalDate localDate = java.time.LocalDate.now();
        Date reminderDate = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        ImmutableReminder immutableObject2 = new ImmutableReminder(reminderDate);
*/

        System.out.println("Stopped..");

    }
}
