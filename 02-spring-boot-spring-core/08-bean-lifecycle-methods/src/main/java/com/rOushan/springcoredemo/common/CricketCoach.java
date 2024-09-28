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
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff method: " + getClass().getSimpleName() + " initialized.");
    }

    //define our destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff method: " + getClass().getSimpleName() + " destroyed.");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily! :-)";
    }
}
