package com.rOushan.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller that handles HTTP requests related to daily workout routines.
 *
 * @RestController indicates that this class is a controller where every method returns a response body.
 * It combines @Controller and @ResponseBody, meaning the returned values from controller methods
 * will be written directly into the HTTP response as JSON or plain text.
 */
@RestController
public class DemoController {

    // Define a private field for the Coach dependency
    private final Coach mycoach;

    /**
     * Constructor-based dependency injection.
     * The @Autowired annotation tells Spring to inject the appropriate Coach implementation.
     *
     * @param mycoach an implementation of the Coach interface, which is injected automatically by Spring.
     */
    @Autowired
    public DemoController(Coach mycoach) {
        this.mycoach = mycoach;
    }

    /**
     * Handle HTTP GET requests for "/dailyWorkout".
     * This method returns the daily workout provided by the injected Coach instance.
     *
     * @return a string containing the workout details.
     */
    @GetMapping("/dailyWorkout")
    public String dailyWorkout() {
        return mycoach.getDailyWorkout();
    }
}
