package com.rOushan.springcoredemo.rest;

import com.rOushan.springcoredemo.common.Coach; // Importing the Coach interface
import org.springframework.beans.factory.annotation.Autowired; // Importing the Autowired annotation
import org.springframework.beans.factory.annotation.Qualifier; // Importing the Qualifier annotation
import org.springframework.web.bind.annotation.GetMapping; // Importing the GetMapping annotation
import org.springframework.web.bind.annotation.RestController; // Importing the RestController annotation

/**
 * DemoController class serves as a REST controller that handles HTTP requests
 * related to daily workout routines.
 */
@RestController
public class DemoController {

    // Define a private final field for the Coach dependency
    // The 'final' keyword ensures that the Coach dependency cannot be changed once initialized
    private final Coach mycoach;

    /**
     * Constructor for DemoController that takes a Coach object as a parameter.
     * The @Autowired annotation tells Spring to automatically inject the required
     * Coach implementation when this method is called.
     *
     * The @Qualifier annotation is used to specify which Coach implementation
     * should be injected when there are multiple implementations available.
     * In this case, it specifies to inject the bean named "trackCoach".
     *
     * @param mycoach the Coach implementation that will be injected
     */
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach mycoach) {
        this.mycoach = mycoach; // Assigning the injected Coach bean to the private field
    }

    /**
     * Handle HTTP GET requests for the "/dailyWorkout" endpoint.
     * When this endpoint is accessed, this method is invoked.
     *
     * @return a string containing the daily workout routine provided by the Coach
     */
    @GetMapping("/dailyWorkout") // Maps HTTP GET requests to this method
    public String dailyWorkout() {
        // Calls the getDailyWorkout method of the Coach and returns the result
        return mycoach.getDailyWorkout(); // The response is written to the HTTP response body
    }
}
