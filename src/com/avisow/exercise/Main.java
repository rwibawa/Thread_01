package com.avisow.exercise;

public class Main {

    public static void main(String[] args) {
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

        Alternate2Threds program = new Alternate2Threds();
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
