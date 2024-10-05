package com.rOushAn.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 'SpringApplication' is a class that provides a convenient way to bootstrap a Spring application.
// 'SpringBootApplication' is an annotation that enables a suite of Spring Boot features like component scanning,
//  auto-configuration, and property support.It simplifies the configuration process.

@SpringBootApplication
// This annotation marks the main class as a Spring Boot application.It does the following:
// 1. Enables auto-configuration, which attempts to automatically configure your Spring application based on the
//    dependencies you have added (e.g., configuring a database if a JPA dependency is present).
// 2. Enables component scanning, which tells Spring to scan for components (like @Service, @Repository, and @Controller annotated classes)
//    within the package and its sub-packages to wire them into the application context.
// 3. Enables Spring Boot's configuration features like externalized configuration (via application.properties or YAML files).

public class MycoolappApplication {
// This is the main class for the Spring Boot application. By convention, it is named with the suffix "Application".

	public static void main(String[] args) {
		// The 'main' method is the entry point of the application when you run it as a standalone Java application.
		// It calls 'SpringApplication.run()', which boots up the Spring application context, loads beans, and sets up the web server (if necessary).

		SpringApplication.run(MycoolappApplication.class, args);
		// 'SpringApplication.run()' is a static method that launches the Spring Boot application. It takes two arguments:
		// 1. The main application class (in this case, 'MycoolappApplication.class') that contains the @SpringBootApplication annotation.
		// 2. Any command-line arguments passed to the application, which can be accessed in the application if needed.
	}
}

