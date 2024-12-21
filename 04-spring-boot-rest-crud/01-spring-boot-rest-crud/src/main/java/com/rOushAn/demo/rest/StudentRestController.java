package com.rOushAn.demo.rest;

import com.rOushAn.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define a GET endpoint at "/api/student"
    // This method will handle HTTP GET requests and return a list of students
    @GetMapping("/student")
    public List<Student> getStudent() {

        // Creating a new ArrayList to hold Student objects
        List<Student> the_student = new ArrayList<>();

        // Adding Student objects to the list with first name and last name
        the_student.add(new Student("Roushan", "Kumar"));
        the_student.add(new Student("Maria", "Rossi"));
        the_student.add(new Student("Nisha", "Kumari"));

        // Returning the list of students
        // This list will be automatically converted to JSON format by Jackson (a library included in Spring)
        // Jackson is used by Spring Boot to serialize Java objects (POJOs) to JSON responses
        return the_student;
    }

    /*
     Explanation:
     - When a GET request is made to "/api/student", this method is called.
     - The @RestController annotation tells Spring to handle requests in this class,
       and any method returning an object (like a List<Student>) is automatically serialized(binded) into JSON format.
     - Jackson (included when Spring Web is a dependency) will look for getter methods in the Student class
       to convert each Student object into JSON.
     - In the background, Jackson uses reflection to find all fields in the Student class and convert them into
       a key-value pair format (JSON).
     - This response can then be consumed by a client like Postman or a web browser, which interprets JSON data.
    */
}
