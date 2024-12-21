package com.rOushAn.springboot.cruddemo.DAO;

import com.rOushAn.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO implementation for the Employee entity using JPA.
 * This class provides methods to perform CRUD operations on the Employee database table.
 */
@Repository // Marks this class as a Spring Data repository for dependency injection.
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field for EntityManager to interact with the database
    private EntityManager entityManager;

    /**
     * Constructor for injecting the EntityManager dependency.
     *
     * @param theEntityManager the EntityManager to interact with the database
     */
    @Autowired // Spring will automatically inject an instance of EntityManager.
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    /**
     * Retrieve all employees from the database.
     *
     * @return a list of Employee entities
     */
    @Override
    public List<Employee> findAll() {
        // Create a query to select all employees from the Employee table
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute the query and get the result list
        List<Employee> employees = theQuery.getResultList();

        // Return the list of employees
        return employees;
    }

    /**
     * Retrieve a specific employee by their ID.
     *
     * @param theId the ID of the employee to retrieve
     * @return the Employee entity, or null if not found
     */
    @Override
    public Employee findById(int theId) {
        // Use the EntityManager's find method to retrieve the employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // Return the retrieved employee
        return theEmployee;
    }

    /**
     * Save or update an employee in the database.
     * If the employee does not exist, a new record is created.
     * If the employee already exists, the record is updated.
     *
     * @param theEmployee the Employee entity to save or update
     * @return the saved or updated Employee entity
     */
    @Override
    public Employee save(Employee theEmployee) {
        // Use the EntityManager's merge method to save or update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // Return the saved or updated employee
        return dbEmployee;
    }

    /**
     * Delete an employee from the database by their ID.
     *
     * @param theId the ID of the employee to delete
     */
    @Override
    public void deleteById(int theId) {
        // Retrieve the employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // If the employee exists, remove it from the database
        if (theEmployee != null) {
            entityManager.remove(theEmployee);
        }
    }
}
