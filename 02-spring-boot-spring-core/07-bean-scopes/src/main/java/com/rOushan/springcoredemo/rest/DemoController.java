package com.rOushan.springcoredemo.rest;

import com.rOushan.springcoredemo.common.Coach; // Importing the Coach interface
import org.springframework.beans.factory.annotation.Autowired; // Importing the Autowired annotation
import org.springframework.beans.factory.annotation.Qualifier; // Importing the Qualifier annotation
import org.springframework.web.bind.annotation.GetMapping; // Importing the GetMapping annotation
import org.springframework.web.bind.annotation.RestController; // Importing the RestController annotation

/**
 * DemoController class serves as a REST controller that handles HTTP requests related to coaching activities.
 */
@RestController
public class DemoController {

    // Define a private field for the first Coach dependency
    private final Coach mycoach;

    // Define a private field for another Coach dependency
    private final Coach anotherCoach;

    /**
     * Constructor for DemoController.
     * Uses dependency injection to provide the required Coach implementations.
     * The @Qualifier annotation specifies which bean to inject when there are multiple candidates.
     *
     * @param mycoach the first Coach implementation to be injected
     * @param anotherCoach the second Coach implementation to be injected
     */
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach mycoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        // Print statement to indicate that the DemoController is initialized
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
        this.mycoach = mycoach; // Assigning the injected Coach bean to the private field
        this.anotherCoach = anotherCoach; // Assigning the injected Coach bean to the private field
    }

    /**
     * Endpoint to check if both Coach instances are the same.
     * If mycoach and another point to the same instance, it indicates the singleton scope.
     *
     * @return a string comparison result indicating whether both instances are the same
     */
    @GetMapping("/check") // Maps HTTP GET requests to this method
    public String check() {
        // Comparing the two Coach instances and returning the result
        return "Comparing beans: mycoach == anotherCoach: " + (mycoach == anotherCoach);
    }

    /**
     * Endpoint to return the daily workout from the mycoach instance.
     *
     * @return a string containing the daily workout routine provided by the Coach
     */
    @GetMapping("/dailyWorkout") // Maps HTTP GET requests to this method
    public String dailyWorkout() {
        // Calls the getDailyWorkout method of the mycoach instance and returns the result
        return mycoach.getDailyWorkout(); // The response is written to the HTTP response body
    }
}
