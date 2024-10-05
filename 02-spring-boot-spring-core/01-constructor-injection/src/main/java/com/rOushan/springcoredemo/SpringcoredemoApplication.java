package com.rOushan.springcoredemo;

//Bootstrap your Spring Boot application
//Behind the scenes:
//Creates an application context
//Registers all beans
//Starts the embedded server (Tomcat, etc.)

import org.springframework.boot.SpringApplication;

//Enables:
//    - Auto configuration
//    - Component scanning
//    - Additional configuration
//Composed of the following annotations:
//    - @EnableAutoConfiguration
//    - @ComponentScan
//    - @Configuration
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for bootstrapping the Spring Boot application.
 * The @SpringBootApplication annotation serves as the entry point for component scanning,
 * configuration, and auto-configuration.
 */
@SpringBootApplication
public class SpringcoredemoApplication {

    /**
     * Main method that launches the Spring Boot application.
     * SpringApplication.run() initializes the Spring context, registers beans, and starts the embedded server (e.g., Tomcat).
     *
     * @param args command-line arguments passed during the application startup (currently not used).
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}

//Constructor Injection is a dependency injection method where required dependencies of a class are passed through its constructor at the time of object creation.
//This ensures the class is fully initialized with all its dependencies, promoting immutability, better testability, and enforcing that the class cannot be instantiated without the necessary components.

//How the Process is working::
//1. Application Startup: SpringApplication.run()
//When you start your application by calling SpringApplication.run(SpringcoredemoApplication.class, args);,the following happens behind the scenes:
//     Spring Boot uses AnnotationConfigApplicationContext, which allows it to scan for beans based on annotations like @Component, @Service, @RestController, and others.
//     During startup, Spring Boot looks for the @SpringBootApplication annotation (in your SpringcoredemoApplication class). This annotation enables Component Scanning, Auto-Configuration, and Configuration.
//     All the classes with these annotations are instantiated and added to the Spring Application Context as beans.
//2. Spring’s Dependency Injection:
//Spring follows the Inversion of Control (IoC) principle, where the control of object creation and management is transferred from the application code to the Spring container.
//     Classes annotated with @Component, @Service, @Repository, or @RestController are detected.
//     Spring creates beans (i.e., instances of these classes) and adds them to the application context.
//     In your example:
//        The CricketCoach class is annotated with @Component, so Spring creates a bean of this class and registers it in the application context.
//        Similarly, the DemoController class is annotated with @RestController, and Spring creates an instance of this controller.
//           Coach theCoach = new CricketCoach();
//           DemoController demoController = new DemoController(theCoach);
//     In DemoController, the Coach interface is a required dependency, and Spring sees the @Autowired annotation on the constructor.
//     Spring looks for a bean that implements the Coach interface. Since CricketCoach is annotated with @Component and implements Coach, Spring injects this bean into DemoController.

//3. Life Cycle Management:
//Behind the scenes, Spring manages the lifecycle of all beans:
//Beans are created when needed (either during startup or lazily when first used).
//Spring manages the scope of each bean (e.g., singleton scope is the default, meaning only one instance of the bean is created).
//Spring handles the destruction of beans gracefully when the application shuts down, calling any necessary cleanup methods if defined.