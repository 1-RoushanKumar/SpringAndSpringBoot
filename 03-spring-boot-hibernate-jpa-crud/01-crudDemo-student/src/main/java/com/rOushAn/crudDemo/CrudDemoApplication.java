package com.rOushAn.crudDemo;

import com.rOushAn.crudDemo.DAO.StudentDAO;
import com.rOushAn.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Main application class for the CRUD Demo application.
 * This class initializes the Spring Boot application and demonstrates CRUD operations on Student objects.
 */
@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    /**
     * CommandLineRunner bean to execute code after the application context is initialized.
     * Demonstrates various CRUD operations on the Student entity using the StudentDAO.
     *
     * @param studentDAO the DAO object for performing database operations
     * @return CommandLineRunner instance
     */
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // Uncomment the desired methods to test specific CRUD operations

            // Create a single student
            // createStudent(studentDAO);

            // Create multiple students
            createMultipleStudent(studentDAO);

            // Retrieve a student by ID
            // readStudent(studentDAO, 2);

            // Query all students
            // queryStudent(studentDAO);

            // Query students by last name
            // queryForStudentByLastName(studentDAO);

            // Update a student
            // updateStudent(studentDAO);

            // Delete a student by ID
            // deleteStudent(studentDAO);

            // Delete all students
            // deleteAllStudents(studentDAO);
        };
    }

    /**
     * Delete all students from the database.
     *
     * @param studentDAO the DAO object
     */
    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    /**
     * Delete a student by ID.
     *
     * @param studentDAO the DAO object
     */
    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with ID: " + studentId);
        studentDAO.delete(studentId);
    }

    /**
     * Update a student's information.
     *
     * @param studentDAO the DAO object
     */
    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 2;

        // Retrieve the student by ID
        System.out.println("Getting student with ID: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // Update the first name
        System.out.println("Updating student ...");
        myStudent.setFirstName("Scooby");

        // Save the updated student
        studentDAO.update(myStudent);

        // Display the updated student
        System.out.println("Updated Student: " + myStudent);
    }

    /**
     * Query students by last name.
     *
     * @param studentDAO the DAO object
     */
    private void queryForStudentByLastName(StudentDAO studentDAO) {
        // Retrieve students with the last name "Doe"
        List<Student> students = studentDAO.findByLastName("Doe");

        // Display the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Query all students from the database.
     *
     * @param studentDAO the DAO object
     */
    private void queryStudent(StudentDAO studentDAO) {
        // Retrieve all students
        List<Student> students = studentDAO.findAll();

        // Display the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Retrieve a student by ID.
     *
     * @param studentDAO the DAO object
     * @param theId      the ID of the student
     */
    private void readStudent(StudentDAO studentDAO, int theId) {
        System.out.println("Retrieving student with ID: " + theId);

        // Find the student by ID
        Student myStudent = studentDAO.findById(theId);

        // Display the retrieved student
        System.out.println("Found the student: " + myStudent);
    }

    /**
     * Create multiple student objects and save them to the database.
     *
     * @param studentDAO the DAO object
     */
    private void createMultipleStudent(StudentDAO studentDAO) {
        // Create new student objects
        System.out.println("Creating new student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "jd@gmail.com");
        Student tempStudent2 = new Student("Jane", "Smith", "js@gmail.com");
        Student tempStudent3 = new Student("David", "Johnson", "dj@gmail.com");

        // Save the student objects to the database
        System.out.println("Saving the student objects ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // Display the IDs of the saved students
        System.out.println("Saved student generated ID: " + tempStudent1.getId());
        System.out.println("Saved student generated ID: " + tempStudent2.getId());
        System.out.println("Saved student generated ID: " + tempStudent3.getId());
    }

    /**
     * Create a single student object and save it to the database.
     *
     * @param studentDAO the DAO object
     */
    private void createStudent(StudentDAO studentDAO) {
        // Create a new student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Roushan", "Kumar", "rk@gmail.com");

        // Save the student object to the database
        System.out.println("Saving the student object ...");
        studentDAO.save(tempStudent);

        // Display the ID of the saved student
        System.out.println("Saved student generated ID: " + tempStudent.getId());
    }
}
