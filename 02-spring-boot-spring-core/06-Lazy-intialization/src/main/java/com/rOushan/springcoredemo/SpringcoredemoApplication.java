package com.rOushan.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}

/**
 * By default, when @Lazy is not specified and `spring.main.lazy-initialization = false` (default behavior),
 * Spring eagerly initializes all beans at application startup.
 * To demonstrate this, constructors were added to the classes, and upon startup, the following output is seen:
 *
 * In constructor: BaseballCoach initialized.
 * In constructor: CricketCoach initialized.
 * In constructor: TennisCoach initialized.
 * In constructor: TrackCoach initialized.
 * In constructor: DemoController initialized.
 *
 * When `spring.main.lazy-initialization = false` (as set in the application properties),
 * Spring creates an instance of each bean and makes them available immediately at startup.
 */

/**
 * Lazy Initialization:
 *
 * Instead of eagerly creating all beans upfront, we can specify lazy initialization.
 * With lazy initialization, a bean is only created when:
 * 1. It is required for dependency injection.
 * 2. It is explicitly requested (e.g., by calling a method or fetching it from the context).
 *
 * To enable lazy initialization for a specific bean, we add the `@Lazy` annotation to that class.
 * Alternatively, setting `spring.main.lazy-initialization = true` in the application properties
 * enables lazy initialization for all beans globally.
 *
 * With lazy initialization enabled (via `@Lazy` or `spring.main.lazy-initialization = true`),
 * no beans are created until they are needed. Only when a bean is injected or explicitly requested
 * will you see the following:
 *
 * In constructor: BaseballCoach initialized.
 * In constructor: CricketCoach initialized.
 * In constructor: TennisCoach initialized.
 * In constructor: DemoController initialized.
 */
