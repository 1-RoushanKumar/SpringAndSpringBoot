package com.rOushAn.springboot.cruddemo.service;

import com.rOushAn.springboot.cruddemo.DAO.EmployeeDAO;
import com.rOushAn.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Employee entities.
 * This class acts as a bridge between the controller and DAO layers, ensuring proper handling of business logic.
 */
@Service // Marks this class as a Spring-managed service component.
public class EmployeeServiceImpl implements EmployeeService {

    // Dependency on the EmployeeDAO for data access operations
    private EmployeeDAO employeeDAO;

    /**
     * Constructor injection of the EmployeeDAO dependency.
     *
     * @param theEmployeeDAO the EmployeeDAO implementation to use
     */
    @Autowired // Automatically wires the EmployeeDAO implementation.
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    /**
     * Retrieve all employees from the database.
     *
     * @return a list of Employee entities
     */
    @Override
    public List<Employee> findAll() {
        // Delegate the call to the DAO layer
        return employeeDAO.findAll();
    }

    /**
     * Retrieve a specific employee by their ID.
     *
     * @param theId the ID of the employee to retrieve
     * @return the Employee entity, or null if not found
     */
    @Override
    public Employee findById(int theId) {
        // Delegate the call to the DAO layer
        return employeeDAO.findById(theId);
    }

    /**
     * Save or update an employee in the database.
     * If the employee does not exist, a new record is created.
     * If the employee already exists, the record is updated.
     *
     * @param theEmployee the Employee entity to save or update
     * @return the saved or updated Employee entity
     */
    @Transactional // Marks the method as transactional for database operations.
    @Override
    public Employee save(Employee theEmployee) {
        // Delegate the save operation to the DAO layer
        return employeeDAO.save(theEmployee);
    }

    /**
     * Delete an employee from the database by their ID.
     *
     * @param theId the ID of the employee to delete
     */
    @Transactional // Marks the method as transactional for database operations.
    @Override
    public void deleteById(int theId) {
        // Delegate the delete operation to the DAO layer
        employeeDAO.deleteById(theId);
    }
}
