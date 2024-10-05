package com.rOushan.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    //define our init method
    //this will be initialized when CricketCoachBean was instantiated.
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff method: " + getClass().getSimpleName() + " initialized.");
    }

    //define our destroy method
    //this method run at last you program is exiting.
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff method: " + getClass().getSimpleName() + " destroyed.");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily! :-)";
    }
}
