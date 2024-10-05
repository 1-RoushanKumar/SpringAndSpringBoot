package com.rOushan.springcoredemo.rest;

import com.rOushan.springcoredemo.common.Coach; // Importing the Coach interface
import org.springframework.beans.factory.annotation.Autowired; // Importing the Autowired annotation
import org.springframework.web.bind.annotation.GetMapping; // Importing the GetMapping annotation
import org.springframework.web.bind.annotation.RestController; // Importing the RestController annotation

/**
 * DemoController class serves as a REST controller that handles HTTP requests
 * related to daily workout routines.
 */
@RestController
public class DemoController {

    // Define a private field for the Coach dependency
    private Coach mycoach; // This will hold the reference to the injected Coach bean

    /**
     * Setter method for dependency injection.
     * The @Autowired annotation tells Spring to automatically inject
     * the required Coach implementation when this method is called.
     *
     * @param mycoach the Coach implementation that will be injected
     */
    @Autowired
    public void setCoach(Coach mycoach) {
        // Assign the injected Coach bean to the private field
        this.mycoach = mycoach; // Now mycoach can be used in other methods of this class
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

// Behind the scenes when using Spring's dependency injection:
// 1. The Spring container creates an instance of the desired Coach implementation, e.g.,
// Coach theCoach = new CricketCoach();
// 2. An instance of DemoController is created by Spring.
// DemoController demoController = new DemoController();
// 3. Spring calls the setter method setCoach(theCoach) to inject the dependency.
// The controller is now fully initialized and can handle requests to the "/dailyWorkout" endpoint.
