package com.rOushAn.springboot.cruddemo.rest;

import com.rOushAn.springboot.cruddemo.DAO.EmployeeDAO;
import com.rOushAn.springboot.cruddemo.entity.Employee;
import com.rOushAn.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller, indicating that the methods in this class will handle HTTP requests.
// REST controllers in Spring automatically return data (e.g., JSON) as a response without needing explicit response body serialization.
@RequestMapping("/api") // Specifies the base URL path for this controller. All endpoints in this class will be prefixed with "/api".
public class EmployeeRestController {

    // Commented out quick and dirty solution using EmployeeDAO directly
    // The approach here was to inject EmployeeDAO directly into the controller
    // which is less modular and not ideal for larger systems.

    //    private EmployeeDAO employeeDAO;
    //
    //    // Quick and dirty: Inject EmployeeDAO directly into the controller
    //    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
    //        employeeDAO = theEmployeeDAO;
    //    }
    //
    //    // Expose "/employees" endpoint to return a list of employees
    //    @GetMapping("/employees")
    //    public List<Employee> findAll() {
    //        return employeeDAO.findAll();
    //    }

    // Now switching to a more structured solution using @Service annotation
    // Purpose of EmployeeService:
    // - Acts as an intermediate layer that contains custom business logic.
    // - Enables integration of data from multiple sources (e.g., EmployeeDAO, SkillsDAO, PayrollDAO).
    // - Promotes modularity and helps in handling business-specific logic.

    private EmployeeService employeeService;

    @Autowired // Indicates that Spring should automatically inject the EmployeeService bean into this class.
    // Dependency injection decouples the controller from the EmployeeService implementation, following the principle of Inversion of Control.
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService; // The injected service is assigned to the local variable for use within this class.
    }

    @GetMapping("/employees") // Maps HTTP GET requests to the specified endpoint "/employees".
    // This endpoint will return a list of all employees as JSON data.
    public List<Employee> findAll() {
        // Calls the service layer, which is responsible for fetching all employees from the DAO or other sources.
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}") // Maps HTTP GET requests to "/employees/{employeeId}", where {employeeId} is a path variable.
    // This endpoint retrieves a specific employee based on their ID.
    public Employee getEmployeeById(@PathVariable int employeeId) {
        // @PathVariable binds the {employeeId} in the URL to the method parameter.
        Employee theEmployee = employeeService.findById(employeeId); // Fetch the employee by ID using the service layer.

        // Check if the employee exists; if not, throw an exception.
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee; // Return the found employee as JSON.
    }

    @PostMapping("/employees") // Maps HTTP POST requests to "/employees".
    // This endpoint is used to add a new employee.
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // @RequestBody binds the JSON payload in the HTTP request body to the Employee object.
        // If an ID is provided in the request, set it to 0 to ensure a new employee is created instead of updating an existing one.
        theEmployee.setId(0);

        // Save the employee using the service layer. The ID will be auto-generated if it's a new entity.
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee; // Return the saved employee, including the generated ID, as JSON.
    }

    @PutMapping("/employees") // Maps HTTP PUT requests to "/employees".
    // This endpoint is used to update an existing employee.
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        // @RequestBody binds the JSON payload in the HTTP request body to the Employee object.

        // Save the updated employee using the service layer. If the employee doesn't exist, this may create a new record depending on the implementation.
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee; // Return the updated employee as JSON.
    }

    @DeleteMapping("/employees/{employeeId}") // Maps HTTP DELETE requests to "/employees/{employeeId}".
    // This endpoint is used to delete an employee by their ID.
    public String deleteEmployee(@PathVariable int employeeId) {
        // Fetch the employee by ID to check if they exist.
        Employee theEmployee = employeeService.findById(employeeId);

        // If the employee doesn't exist, throw an exception.
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // Delete the employee using the service layer.
        employeeService.deleteById(employeeId);

        // Return a confirmation message as a plain string.
        return "Deleted employee id - " + employeeId;
    }
}
