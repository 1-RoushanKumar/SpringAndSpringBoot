package com.rOushAn.demo.rest;

import com.rOushAn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Step 1: Create StudentErrorResponse class which have three parameters with getter and setter methods.
    // Step 2: Create Own StudentNotFoundException
    // Step 3: Throw StudentNotFoundException
    // Step 4: Last Create Exception Handler.

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

    // Add an exception handler using @ExceptionHandler
    // Uncommented handler for specific StudentNotFoundException (commented out for more generic handling)
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
    //     // Create a StudentErrorResponse
    //     StudentErrorResponse error = new StudentErrorResponse();
    //     error.setStatus(HttpStatus.NOT_FOUND.value());
    //     error.setMessage(exc.getMessage());
    //     error.setTimestamp(System.currentTimeMillis());
    //     // Return ResponseEntity
    //     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    // }

    // This exception works very well, but only for integerTypes errors
    // What if user added "abc" as a studentId then this exception handler not works
    // and the MethodArgumentMisMatch exception gets thrown.
    // So, for handling these all types of errors, we need generic exceptions' handler.

    // Add another exception handler ... to catch any exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // Create a generic error response for any exception
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // Set the status to BAD_REQUEST
        error.setMessage(exc.getMessage()); // Set the error message from the exception
        error.setTimestamp(System.currentTimeMillis()); // Set the current timestamp
        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // Return the error response with BAD_REQUEST status
    }
}
