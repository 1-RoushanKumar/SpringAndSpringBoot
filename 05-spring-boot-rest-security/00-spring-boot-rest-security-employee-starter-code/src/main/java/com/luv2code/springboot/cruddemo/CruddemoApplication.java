package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the CRUD Demo project.
 * This class is responsible for bootstrapping the Spring Boot application.
 *
 * Key Features:
 * - Utilize Spring Boot's auto-configuration and application context setup.
 * - Includes Spring Security integration for securing the application.
 *
 * Spring Security Integration:
 * 1. **Dependency Addition**:
 *    - The `spring-boot-starter-security` dependency is added to the `pom.xml`.
 *    - This dependency automatically configures basic security for the application.
 *    - By default, Spring Security enables a form of HTTP Basic Authentication with a default username (`user`) and a generated password (displayed in the console when the application starts).
 *
 * 2. **Customizing Username and Password**:
 *    - You can override the default credentials by specifying properties in the `application.properties` file:
 *      ```
 *      spring.security.user.name=yourUsername
 *      spring.security.user.password=yourPassword
 *      ```
 *    - Example:
 *      ```
 *      spring.security.user.name=roushan
 *      spring.security.user.password=1234
 *      ```
 *
 * Notes:
 * - These settings are for development purposes. In production, consider implementing a more robust user authentication and authorization mechanism.
 */
@SpringBootApplication
public class CruddemoApplication {

	/**
	 * The entry point of the Spring Boot application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
