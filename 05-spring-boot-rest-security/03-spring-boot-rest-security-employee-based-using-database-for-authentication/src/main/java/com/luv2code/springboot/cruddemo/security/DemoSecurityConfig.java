package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/**
 * Security configuration for the CRUD demo application.
 *
 * Configures JDBC-based user management and role-based access control for API endpoints.
 */
@Configuration
public class DemoSecurityConfig {

    /**
     * Configures a JdbcUserDetailsManager to retrieve user details and roles from the database.
     *
     * @param dataSource the application's database for user and authority data
     * @return a JdbcUserDetailsManager instance
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * Configures the security filter chain for HTTP requests.
     * Specifies role-based access control and basic authentication for REST APIs.
     *
     * @param http the HttpSecurity object for configuring security rules
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE") // Access for EMPLOYEE role
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE") // Access for EMPLOYEE role
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER") // Access for MANAGER role
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER") // Access for MANAGER role
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN") // Access for ADMIN role
        );

        // Enable HTTP Basic Authentication for simplicity
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF protection for stateless REST APIs
        http.csrf(csrf -> csrf.disable());

        // Return the built security filter chain
        return http.build();
    }
}