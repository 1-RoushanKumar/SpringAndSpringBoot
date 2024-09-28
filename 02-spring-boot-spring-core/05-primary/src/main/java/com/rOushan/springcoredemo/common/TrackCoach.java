package com.rOushan.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Track Coach: Run 1.5 km daily!";
    }
}
