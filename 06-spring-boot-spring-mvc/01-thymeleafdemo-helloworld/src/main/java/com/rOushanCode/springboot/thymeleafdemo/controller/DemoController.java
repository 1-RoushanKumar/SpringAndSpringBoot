package com.rOushanCode.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller; // Annotation to mark this class as a Spring MVC controller
import org.springframework.ui.Model; // Interface used to pass data to the view
import org.springframework.web.bind.annotation.GetMapping; // Annotation for handling GET requests

@Controller // Marks this class as a Spring MVC controller that handles web requests
public class DemoController {

    // Method to handle GET requests for the "/hello" URL
    @GetMapping("/hello") // Maps HTTP GET requests to this method when the "/hello" URL is accessed
    public String sayHello(Model theModel) {
        // Adds a current date and time object (LocalDateTime) to the model with the key "theDate"
        // The model data will be available to the view (Thymeleaf template)
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        // Returns the logical view name "helloworld"
        // This tells Spring to render the Thymeleaf template located at "src/main/resources/templates/helloworld.html"
        return "helloworld";
    }
}
