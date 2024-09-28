package com.rOushAn.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return a "Hello, World!"
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "fortune
    @GetMapping("/fortune")
    public String getFortune() {
        return "Your lucky number is 7!";
    }

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for "teamInfo"
    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "The coach's name is " + coachName + " and the team's name is " + teamName;
    }
}
