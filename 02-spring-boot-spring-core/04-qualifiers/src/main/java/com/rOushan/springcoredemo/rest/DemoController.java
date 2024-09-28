package com.rOushan.springcoredemo.rest;

import com.rOushan.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the coach dependency
    private Coach mycoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach mycoach) {
        this.mycoach = mycoach;
    }

    @GetMapping("/dailyWorkout")
    public String dailyWorkout() {
        return mycoach.getDailyWorkout();
    }
}
