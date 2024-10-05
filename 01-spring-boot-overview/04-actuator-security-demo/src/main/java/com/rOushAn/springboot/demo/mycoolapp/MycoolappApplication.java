package com.rOushAn.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }
}
//First
// do this before adding security dependencies to the pom.xml or comment the security dependencies from the pom.xml
////when we use actuator some time, we don't want to expose all the information


//Second
// go to pom.xml and add spring-boot-starter-security
// if you don't' want to expose all the information, you can add security which will ask for the
// login username and password
// default username = user
// check console for the password.

//if you do some changes in application.properties the must-rerun the code.
//in detail we will learn it later on the course.