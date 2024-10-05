package com.rOushAn.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }
}
//Run this first for understanding what happens before this comments all exposed endpoints from application properties.
//First: adding the dependency spring-boot-starter-actuator.
//After adding the dependency,
//it automatically exposed the endpoints(means adding them to the url)for the actuator and health
//you can use "localhost:8080/actuator and "localhost:8080/actuator/health" these are available by default.

//Second:For running another actuator like "/info","/beans"
//we need to add exposure endpoints to the application properties.
//go to application properties to see the properties

//Second to expose all the actuator endpoints over HTTP, we use wildcard "*"
//there are more different types of actuator you can see online.