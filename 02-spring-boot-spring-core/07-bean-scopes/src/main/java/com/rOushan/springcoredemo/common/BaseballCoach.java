package com.rOushan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball Coach: Hit 40 home runs daily!!!";
    }
}
