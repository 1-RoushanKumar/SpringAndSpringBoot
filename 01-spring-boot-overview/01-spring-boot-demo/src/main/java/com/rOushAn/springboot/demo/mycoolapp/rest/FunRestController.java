package com.rOushAn.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// These 'import' statements bring in necessary Spring classes for building RESTful web services.
// 'RestController' is a Spring annotation used to create RESTful web services. It tells Spring that this class
// is a web controller, and its return values should be bound to the web response body.
// 'GetMapping' is an annotation used to map HTTP GET requests to specific handler methods in the controller.

@RestController
// This annotation marks the class as a REST controller, meaning it handles HTTP requests and sends responses.
// It combines the functionalities of @Controller and @ResponseBody, allowing for simpler configuration
// of RESTful endpoints (without needing to separately annotate the response body).

public class FunRestController {
// This is the REST controller class, which contains handler methods for incoming HTTP requests.

    // expose "/" that returns a "Hello, World!"
    @GetMapping("/")
    // The '@GetMapping("/")' annotation maps HTTP GET requests to the root URL ("/") to this method.
    // When someone accesses the root URL, this method will be invoked.
    public String helloWorld() {
        // This method handles the HTTP GET request to "/". It simply returns a String "Hello, World!"
        // as the response body to the client.
        return "Hello, World!";
    }
}
