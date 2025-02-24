package com.sample.ecomm.others.scheduler;

import java.util.concurrent.*;

public class SchedulerExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Task executed at: " + System.currentTimeMillis());

        // Schedule task to run every 5 seconds (initial delay = 0)
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

        // scheduler.scheduleWithFixedDelay(task, 0, 5, TimeUnit.SECONDS); // Alternative
    }
}
