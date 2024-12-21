package com.rOushAn.crudDemo.DAO;

import com.rOushAn.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the StudentDAO interface.
 * This class provides CRUD operations for the Student entity using JPA's EntityManager.
 */
@Repository // Marks this class as a Spring Data repository for dependency injection.
public class StudentDAOImple implements StudentDAO {

    // Define field for EntityManager
    private final EntityManager entityManager;

    /**
     * Constructor for dependency injection of the EntityManager.
     *
     * @param entityManager the EntityManager to interact with the database
     */
    @Autowired
    public StudentDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Save a student to the database.
     * Uses JPA's `persist` method to insert the student entity.
     *
     * @param theStudent the Student entity to save
     */
    @Transactional // Marks the method as transactional to manage the persistence context.
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    /**
     * Find a student by their ID.
     *
     * @param id the ID of the student to retrieve
     * @return the Student entity, or null if not found
     */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    /**
     * Retrieve all students from the database, ordered by last name in ascending order.
     *
     * @return a list of Student entities
     */
    @Override
    public List<Student> findAll() {
        // Create a query to retrieve all students and order them by last name
        TypedQuery<Student> query = entityManager.createQuery("From Student order by lastName asc", Student.class);
        return query.getResultList();
    }

    /**
     * Find students by their last name.
     * Supports exact matching using the parameterized query.
     *
     * @param theLastName the last name to search for
     * @return a list of Student entities matching the last name
     */
    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create a query to find students with the specified last name
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName LIKE :theData", Student.class);
        query.setParameter("theData", theLastName); // Set the query parameter
        return query.getResultList();
    }

    /**
     * Update an existing student in the database.
     * Uses JPA's `merge` method to update the entity.
     *
     * @param theStudent the Student entity to update
     */
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    /**
     * Delete a student by their ID.
     *
     * @param id the ID of the student to delete
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        // Retrieve the student entity by ID
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) {
            // Delete the student entity
            entityManager.remove(theStudent);
        }
    }

    /**
     * Delete all students from the database.
     *
     * @return the number of rows deleted
     */
    @Override
    @Transactional
    public int deleteAll() {
        // Execute a query to delete all rows from the Student table
        return entityManager.createQuery("Delete from Student").executeUpdate();
    }
}
