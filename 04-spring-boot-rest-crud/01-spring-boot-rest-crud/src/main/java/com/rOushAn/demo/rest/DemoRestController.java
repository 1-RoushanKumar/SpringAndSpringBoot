package com.rOushAn.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller to handle HTTP requests for the `/test` endpoint.
 * This controller demonstrates a simple REST API that responds with a greeting.
 */
@RestController // Marks the class as a RESTful controller in Spring.
@RequestMapping("/test") // Base URL for all endpoints in this controller.
public class DemoRestController {

    /**
     * Handles GET requests to `/test/hello`.
     * This endpoint returns a simple "Hello World!" message.
     *
     * @return a greeting string "Hello World!"
     */
    @GetMapping("/hello") // Maps GET requests for `/hello` to this method.
    public String sayHello() {
        // Return a simple greeting message
        return "Hello World!";
    }
}
