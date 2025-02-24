package com.sample.ecomm.others.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerExample {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static class MyJob implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            System.out.println("Quartz Job Executed: " + System.currentTimeMillis());
        }
    }
}
