package com.rOushAn.springboot.demoSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // Bean to define in-memory user details manager with three users
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // Creating a user 'john' with role 'EMPLOYEE'
        UserDetails john = User.builder()
                .username("john")            // Username: john
                .password("{noop}test123")   // Password: test123 (NoOpPasswordEncoder is used for plain text)
                .roles("EMPLOYEE")           // Role: EMPLOYEE
                .build();

        // Creating a user 'mary' with roles 'EMPLOYEE' and 'MANAGER'
        UserDetails mary = User.builder()
                .username("mary")            // Username: mary
                .password("{noop}test123")   // Password: test123
                .roles("EMPLOYEE", "MANAGER")// Roles: EMPLOYEE, MANAGER
                .build();

        // Creating a user 'susan' with roles 'EMPLOYEE', 'MANAGER', and 'ADMIN'
        UserDetails susan = User.builder()
                .username("susan")           // Username: susan
                .password("{noop}test123")   // Password: test123
                .roles("EMPLOYEE", "MANAGER", "ADMIN") // Roles: EMPLOYEE, MANAGER, ADMIN
                .build();

        // Returning an InMemoryUserDetailsManager with the above users
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    // Bean to configure HTTP security for the application
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configuring URL-based access control
                .authorizeHttpRequests(configurer ->
                        configurer
                                // Allowing access to the root URL ("/") only for users with 'EMPLOYEE' role
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                // Allowing access to '/leaders/**' URLs only for users with 'MANAGER' role
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                // Allowing access to '/systems/**' URLs only for users with 'ADMIN' role
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                // For any other URL, the user must be authenticated
                                .anyRequest().authenticated()
                )
                // Configuring login settings
                .formLogin(form ->
                        form
                                // Custom login page URL
                                .loginPage("/showMyLoginPage")
                                // URL for the form processing
                                .loginProcessingUrl("/authenticateTheUser")
                                // Permitting all users to access the login page
                                .permitAll()
                )
                // Configuring logout settings
                .logout(logout -> logout.permitAll()) // Permitting all users to log out
                // Configuring access denied page for unauthorized access attempts
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        // Returning the HTTP security configuration
        return http.build();
    }
}
