package com.rOushan.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName() + " initialized.");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice 100 balls daily! :-)";
    }
}
