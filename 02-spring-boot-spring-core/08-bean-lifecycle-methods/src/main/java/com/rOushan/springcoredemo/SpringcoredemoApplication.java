package com.rOushan.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringcoredemoApplication is the main entry point for the Spring Boot application.
 * It starts the Spring application context and initializes the application.
 */
@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}

// Bean Lifecycle:
// 1. Container Started
// 2. Bean Instantiated
// 3. Dependencies Injected
// 4. Internal Spring Processing
// 5. Your Custom Init Methods
// 6. Bean is Ready for Use
// 7. Container is Shut Down
// 8. Your Custom Destroy Method

// Bean Lifecycle Methods / Hooks:
// • You can add custom code during bean initialization:
//   - Calling custom business logic methods
//   - Setting up handles to resources (e.g., database connections, sockets, files, etc.)
//
// • You can add custom code during bean destruction:
//   - Calling custom business logic methods
//   - Cleaning up handles to resources (e.g., closing database connections, sockets, files, etc.)

// Init method configuration example:
// @PostConstruct
// public void doMyStartupStuff() {
//     System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
// }

// Destroy method configuration example:
// @PreDestroy
// public void doMyCleanupStuff() {
//     System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
// }
