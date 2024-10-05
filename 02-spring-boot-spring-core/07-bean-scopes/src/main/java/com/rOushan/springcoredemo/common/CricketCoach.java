package com.rOushan.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory; // Importing the ConfigurableBeanFactory class for scope configuration
import org.springframework.context.annotation.Scope; // Importing the Scope annotation
import org.springframework.stereotype.Component; // Importing the Component annotation

/**
 * CricketCoach class represents a specific type of coach in the application.
 * It provides workout routines for cricket practice.
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// Specifies that a new instance of this bean will be created each time it is requested
@Component // Marks this class as a Spring component (bean) for dependency injection
public class CricketCoach implements Coach {

    /**
     * Constructor for the CricketCoach class.
     * It prints a message to the console when a new instance is created.
     */
    public CricketCoach() {
        // Log the creation of a new CricketCoach instance
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    /**
     * Provides the daily workout routine for cricket practice.
     *
     * @return a string containing the daily workout routine
     */
    public String getDailyWorkout() {
        // Return a message with the daily workout routine for cricket
        return "Practice cricket for 15 minutes.";
    }
}
