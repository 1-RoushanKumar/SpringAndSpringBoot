package com.rOushan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    @Override
    public String getDailyWorkout() {
        return "Track Coach: Run 1.5 km daily!";
    }
}
