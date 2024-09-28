package com.rOushan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CrickedCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily! :-)";
    }
}
