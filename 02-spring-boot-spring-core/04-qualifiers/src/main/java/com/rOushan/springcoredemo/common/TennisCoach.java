package com.rOushan.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach  {
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach: Practice 100 shots daily!";
    }
}
