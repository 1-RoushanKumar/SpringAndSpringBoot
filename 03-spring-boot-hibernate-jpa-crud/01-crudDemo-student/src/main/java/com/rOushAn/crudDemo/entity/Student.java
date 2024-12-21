package com.rOushAn.crudDemo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a Student.
 * This class maps to the "student" table in the database and is used for persistence with JPA.
 */
@Entity // Specifies that the class is an entity and is mapped to a database table.
@Table(name = "student") // Specifies the name of the table to which this entity is mapped.
public class Student {

    // Define fields (columns in the database)

    /**
     * The primary key for the student entity.
     * Auto-generated using the IDENTITY strategy, which lets the database handle ID generation.
     */
    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key should be generated.
    @Column(name = "id") // Maps this field to the "id" column in the table.
    private int id;

    /**
     * The first name of the student.
     * Maps to the "first_name" column in the database.
     */
    @Column(name = "first_name") // Maps this field to the "first_name" column in the table.
    private String firstName;

    /**
     * The last name of the student.
     * Maps to the "last_name" column in the database.
     */
    @Column(name = "last_name") // Maps this field to the "last_name" column in the table.
    private String lastName;

    /**
     * The email address of the student.
     * Maps to the "email" column in the database.
     */
    @Column(name = "email") // Maps this field to the "email" column in the table.
    private String email;

    // Define constructors

    /**
     * Default no-argument constructor.
     * Required by JPA for entity instantiation.
     */
    public Student() {
    }

    /**
     * Parameterized constructor to create a new student object.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email     the email address of the student
     */
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Define getters and setters

    /**
     * Gets the ID of the student.
     *
     * @return the student ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     *
     * @param id the student ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the student.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the student.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // Define toString method

    /**
     * Returns a string representation of the Student object.
     *
     * @return a string containing the student details
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
