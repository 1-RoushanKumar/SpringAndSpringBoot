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
}
