package com.rOushAn.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotation to indicate that this class is a REST controller
@RestController
public class FunRestController {

    // This method exposes the root endpoint ("/") that returns a greeting message
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!"; // Returns a simple greeting
    }

    // This method exposes a new endpoint ("/workout") that provides a daily workout suggestion
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!"; // Returns a workout suggestion
    }

    // This method exposes a new endpoint ("/fortune") that provides a fortune message
    @GetMapping("/fortune")
    public String getFortune() {
        return "Your lucky number is 7!"; // Returns a fortune message
    }

    // Injecting properties for coach's name and team's name from the application.properties file
    @Value("${coach.name}") // Retrieves the value of 'coach.name' from application properties
    private String coachName; // Holds the coach's name

    @Value("${team.name}") // Retrieves the value of 'team.name' from application properties
    private String teamName; // Holds the team's name

    // This method exposes a new endpoint ("/teamInfo") that provides information about the coach and team
    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        // Returns a string that includes both the coach's name and the team's name
        return "The coach's name is " + coachName + " and the team's name is " + teamName;
    }
}
