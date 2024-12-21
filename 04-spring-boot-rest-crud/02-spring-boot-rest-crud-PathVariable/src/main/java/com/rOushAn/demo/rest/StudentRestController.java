package com.rOushAn.demo.rest;

import com.rOushAn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Previously, the List<Student> was defined inside the getStudent method,
    // which led to the list being recreated every time the endpoint was called.
    // To avoid this unnecessary overhead, we define 'the_student' as a class-level field.
    // This ensures the list is only initialized once and reused across multiple requests.

    private List<Student> the_student;

    // The @PostConstruct annotation ensures that this method is executed after the constructor
    // and dependency injection have been completed. Here, we're using it to load our student data only once,
    // when the bean (StudentRestController) is created. This way, we avoid re-running the initialization
    // logic every time the /student endpoint is called.
    @PostConstruct
    public void loadData() {
        // Initialize the list of students
        the_student = new ArrayList<>();

        // Add sample student data to the list, which will be returned via the API endpoints.
        the_student.add(new Student("Roushan", "Kumar"));
        the_student.add(new Student("Maria", "Rossi"));
        the_student.add(new Student("Nisha", "Kumari"));
    }

    // The getStudent() method returns the list of students when the "/student" endpoint is hit.
    // Since the list is already initialized via the @PostConstruct method, this method simply returns the data.
    // The use of @GetMapping automatically maps HTTP GET requests to this method.
    @GetMapping("/student")
    public List<Student> getStudent() {
        return the_student;
    }

    // This method handles GET requests to "/student/{studentId}", where 'studentId' is a path variable.
    // The @PathVariable annotation binds the 'studentId' from the URL to the method parameter.
    // That is,@PathVariable annotation is used to retrieve the data from the URL path.
    // This allows us to return a specific student based on their index in the list.
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        // For now, we assume that 'studentId' is the index of the student in the list.
        // So, we retrieve the student using the 'studentId' as an index in 'the_student' list.
        return the_student.get(studentId);
    }

    //What happens if we add some bad data on it. Like: character in place of index Or we have here only 3 students,
    //but we are trying to access 7th student then Code will show error, and it also shows server error 500.
    //So, For fixing this, we need to add exception handling.
    //See the Next file Project for this.
}
