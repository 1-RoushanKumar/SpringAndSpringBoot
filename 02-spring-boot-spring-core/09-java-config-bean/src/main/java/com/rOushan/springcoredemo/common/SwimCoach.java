package com.rOushan.springcoredemo.common;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach: Swim for 1 hour daily!";
    }
}
