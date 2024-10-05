package com.rOushAn.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }
}
//You need your app to be configurable.
//You need to read app configuration from an application properties file.
//You can define any properties on this file.
//Your spring boot app can access properties using @Value.

//First, we defined:
//coach.name = "Mickey Mouse"
//team.name = "The Mouse Club"
//Then used @Value in FunRestController file to inject this property to our application.

//Second, we can change the server port, context path, etc.
//There are more than 1000 properties.(you can see online)