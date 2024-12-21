package com.rOushAn.springboot.cruddemo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing an Employee.
 * This class is mapped to the "employee" table in the database.
 */
@Entity
@Table(name = "employee")
public class Employee {

    // Primary key for the employee table.
    // @Id marks this field as the primary key.
    // @GeneratedValue(strategy = GenerationType.IDENTITY) specifies auto-generation of the primary key value.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps this field to the "id" column in the table.
    private int id;

    // Mapping the "firstName" field to the "first_name" column in the database.
    @Column(name = "first_name")
    private String firstName;

    // Mapping the "lastName" field to the "last_name" column in the database.
    @Column(name = "last_name")
    private String lastName;

    // Mapping the "email" field to the "email" column in the database.
    @Column(name = "email")
    private String email;

    /**
     * Default constructor.
     * Required by JPA.
     */
    public Employee() {
        // Empty constructor for JPA
    }

    /**
     * Parameterized constructor for creating an Employee object.
     * @param firstName Employee's first name.
     * @param lastName Employee's last name.
     * @param email Employee's email address.
     */
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Getter for id field.
     * @return the employee's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id field.
     * @param id the id to set for the employee.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for firstName field.
     * @return the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName field.
     * @param firstName the first name to set for the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName field.
     * @return the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName field.
     * @param lastName the last name to set for the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for email field.
     * @return the employee's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email field.
     * @param email the email to set for the employee.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Overriding the toString() method to provide a string representation of the Employee object.
     * @return a string representing the employee with their id, first name, last name, and email.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
