package com.sample.ecomm.others.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public class ScheduledTasks {

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void fixedRateTask() {
        System.out.println("Fixed Rate Task - " + LocalTime.now());
    }

    // Runs 3 seconds after the previous task completes
    @Scheduled(fixedDelay = 3000)
    public void fixedDelayTask() {
        System.out.println("Fixed Delay Task - " + LocalTime.now());
    }

    // Runs every day at 10:30 AM (using cron expression)
    @Scheduled(cron = "0 40 11 * * ?")
    public void cronTask() {
        System.out.println("Cron Task (10:30 AM) - " + LocalTime.now());
    }
}

