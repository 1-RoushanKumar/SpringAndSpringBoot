package com.rOushAn.demo.rest;

import com.rOushAn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> the_student; // List to hold student data

    // Load initial student data into the list after the bean's properties have been set
    @PostConstruct
    public void loadData() {
        the_student = new ArrayList<>();
        the_student.add(new Student("Roushan", "Kumar"));
        the_student.add(new Student("Maria", "Rossi"));
        the_student.add(new Student("Nisha", "Kumari"));
    }

    // Endpoint to retrieve all students
    @GetMapping("/student")
    public List<Student> getStudent() {
        return the_student; // Return the list of students
    }

    // Endpoint to retrieve a student by ID
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        // Step 3:
        // Check if the studentId is valid (within bounds of the list)
        if (studentId >= the_student.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return the_student.get(studentId); // Return the student object at the specified index
    }


    //In the previous files project we have exception handler inside the StudentRestController
    //It works, but ... This ExceptionHandler code is only for the specific Rest Controller
    //Can't be reused by other controllers
    //And in large projects will have multiple controllers. If we create an Exception Handler for each controller is not good practice.
    //So, we need a Global Exception Handler
    //We implement this by using Spring @ControllerAdvice with StudentRestExceptionHandler Class.

}
