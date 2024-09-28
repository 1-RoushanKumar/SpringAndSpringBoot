package com.rOushan.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily! :-)";
    }
}
