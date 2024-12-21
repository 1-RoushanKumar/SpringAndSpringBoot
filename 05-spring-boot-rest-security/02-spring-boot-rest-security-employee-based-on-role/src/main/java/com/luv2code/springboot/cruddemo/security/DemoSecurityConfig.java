package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Configuration Class for the CRUD demo application.
 *
 * This class configures security settings for the application, including:
 * - In-memory user authentication with predefined users and roles.
 * - Role-based access control for REST API endpoints.
 * - HTTP Basic Authentication as a simple authentication mechanism.
 * - CSRF (Cross-Site Request Forgery) protection disabled for REST APIs.
 *
 * This setup is suitable for development and testing environments but should
 * be enhanced with proper security measures for production use.
 */
@Configuration
public class DemoSecurityConfig {

    /**
     * Configures an in-memory user details manager with predefined users and their roles.
     *
     * Each user is assigned specific roles to control access to API endpoints.
     * Passwords are prefixed with `{noop}` to indicate no password encoding.
     *
     * **Defined Users**:
     * - **John**: Role - Employee (Basic access rights).
     * - **Mary**: Roles - Employee, Manager (Intermediate access rights).
     * - **Susan**: Roles - Employee, Manager, Admin (Full access rights).
     *
     * **Why In-Memory Authentication?**
     * - In-memory authentication is simple and suitable for development or testing.
     * - For production, a database-backed or external authentication provider (like LDAP) is recommended.
     *
     * @return InMemoryUserDetailsManager containing user details.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // Create a user with the role "Employee"
        UserDetails john = User.builder()
                .username("john") // Username for login
                .password("{noop}test123") // Password in plain text (no encoding)
                .roles("Employee") // Role assignment
                .build();

        // Create a user with the roles "Employee" and "Manager"
        UserDetails mary = User.builder()
                .username("mary") // Username for login
                .password("{noop}test123") // Password in plain text (no encoding)
                .roles("Employee", "Manager") // Multiple roles assigned
                .build();

        // Create a user with the roles "Employee", "Manager", and "Admin"
        UserDetails susan = User.builder()
                .username("susan") // Username for login
                .password("{noop}test123") // Password in plain text (no encoding)
                .roles("Employee", "Manager", "Admin") // Full access roles
                .build();

        // Return an InMemoryUserDetailsManager that contains these predefined users
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    /**
     * Configures the security filter chain to define authorization and authentication rules.
     *
     * **Features**:
     * - Role-based access control for API endpoints.
     * - HTTP Basic Authentication for simplicity.
     * - CSRF protection disabled for stateless REST APIs.
     *
     * **Authorization Rules**:
     * - GET requests to `/api/employees` and `/api/employees/{id}`: Accessible by users with the "Employee" role.
     * - POST and PUT requests to `/api/employees`: Accessible by users with the "Manager" role.
     * - DELETE requests to `/api/employees/{id}`: Accessible by users with the "Admin" role.
     *
     * **Why Disable CSRF?**
     * - CSRF protection is not needed for REST APIs because they are typically stateless.
     * - This application assumes that clients (like Postman or front-end frameworks) are responsible for API consumption.
     *
     * @param http HttpSecurity object used to configure security settings.
     * @return A SecurityFilterChain object that defines the security configuration.
     * @throws Exception if there are issues with the security configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configure role-based access control for specific API endpoints
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Allow GET requests to the base employees endpoint for "Employee" role
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("Employee")
                        // Allow GET requests to individual employee details for "Employee" role
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("Employee")
                        // Allow POST requests to add new employees for "Manager" role
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("Manager")
                        // Allow PUT requests to update employee details for "Manager" role
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("Manager")
                        // Allow DELETE requests to remove an employee for "Admin" role
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("Admin")
        );

        // Configure HTTP Basic Authentication as the authentication mechanism
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF protection (not required for stateless REST APIs)
        http.csrf(csrf -> csrf.disable());

        // Build and return the security filter chain
        return http.build();
    }
}
