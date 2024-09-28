package com.rOushan.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CrickedCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily!!!";
    }
}
