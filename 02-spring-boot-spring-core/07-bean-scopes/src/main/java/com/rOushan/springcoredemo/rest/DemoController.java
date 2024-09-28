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
    private Coach anotherCoach;
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach mycoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
        this.mycoach = mycoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: mycoach == anotherCoach: " + (mycoach == anotherCoach);
    }
    @GetMapping("/dailyWorkout")
    public String dailyWorkout() {
        return mycoach.getDailyWorkout();
    }
}
