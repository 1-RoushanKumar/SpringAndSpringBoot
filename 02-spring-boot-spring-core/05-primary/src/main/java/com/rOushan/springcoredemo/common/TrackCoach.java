package com.rOushan.springcoredemo.common;

import org.springframework.context.annotation.Primary; // Importing the Primary annotation
import org.springframework.stereotype.Component; // Importing the Component annotation

/**
 * TrackCoach class is an implementation of the Coach interface,
 * providing specific workout routines for track athletes.
 */
@Primary // Indicates that this bean should be given preference when multiple beans of the same type exist
@Component // Marks this class as a Spring component, making it eligible for component scanning
public class TrackCoach implements Coach {

    /**
     * Provides the daily workout routine for track athletes.
     *
     * @return a string containing the daily workout advice
     */
    @Override
    public String getDailyWorkout() {
        // Returning the workout routine specific to track coaching
        return "Track Coach: Run 1.5 km daily!";
    }
}

//The @Primary annotation indicates that this bean (i.e., TrackCoach) should be given preference when multiple beans of the same type exist.
//If another bean of type Coach is also present and injected without a qualifier, Spring will use this TrackCoach implementation by default.

//Instead of specifying a coach by name using @Qualifier
//• I simply need a coach … I don’t care which coach
//• If there are multiple coaches
//• Then you coach figure it out … and tell me who’s the primary coach

//When using @Primary, can have only one for multiple implementations
//• If you mark multiple classes with @Primary … umm, we have a problem
//  more than one 'primary' bean found among candidate error.

//If you mix @Primary and @Qualifier
//• @Qualifier has higher priority

//In general, I recommend using @Qualifier
//• More specific
//• Higher priority

