package com.rOushAn.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return a "Hello, World!"
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    // The'@GetMapping("/workout")' annotation maps HTTP GET requests to the root URL ("/workout") to this method.
    // When someone accesses the root URL, this method will be invoked.
    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "fortune
    @GetMapping("/fortune")
    public String getFortune() {
        return "Your lucky number is 7!";
    }
}
