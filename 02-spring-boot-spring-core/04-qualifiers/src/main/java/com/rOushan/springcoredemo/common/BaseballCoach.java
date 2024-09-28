package com.rOushan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball Coach: Hit 40 home runs daily!!!";
    }
}
