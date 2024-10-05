package com.rOushan.springcoredemo;

import org.springframework.stereotype.Component;

/**
 * The CricketCoach class is a Spring-managed component that implements the Coach interface.
 *
 * @Component marks the class as a Spring Bean. A Spring Bean is simply a regular Java class
 * that is managed by Spring’s IoC (Inversion of Control) container.
 * <p>
 * Once the class is marked with @Component, Spring can automatically detect it during component scanning
 * and register it in the application context. The bean will also be available for dependency injection
 * wherever needed.
 */
@Component
public class CricketCoach implements Coach {

    /**
     * Provides the daily workout for cricket players.
     *
     * @return A string containing the workout instruction: "Cricket Coach: Practice 100 balls daily!!!"
     */
    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily!!!";
    }
}
