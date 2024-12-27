package com.rOushAn.cruddemo;

import com.rOushAn.cruddemo.dao.AppDao;
import com.rOushAn.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> {
//            createCourseAndStudents(appDao);

//            findCourseAndStudents(appDao);

//            findStudentAndCourse(appDao);


//            addMoreCoursesForStudent(appDao);

//            deleteCourse(appDao);

            deleteStudent(appDao);
        };
    }

    private void deleteStudent(AppDao appDao) {
        int theId = 2;

        System.out.println("Deleting student with id: " + theId);

        appDao.deleteStudentById(theId);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDao appDao) {
        int theId = 10;
        Course tempCourse = appDao.findCourseById(theId);

        System.out.println("Deleting course: " + tempCourse);

        appDao.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(AppDao appDao) {
        int theId = 2;
        Student tempStudent = appDao.findStudentAndCourseByStudentId(theId);

        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");

        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Saving student: " + tempStudent);
        System.out.println("associated Courses: " + tempStudent.getCourses());

        appDao.updateStudent(tempStudent);

        System.out.println("Done!");

    }

    private void findStudentAndCourse(AppDao appDao) {
        int theId = 2;
        Student tempStudent = appDao.findStudentAndCourseByStudentId(theId);

        System.out.println("Updating student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDao appDao) {
        int theId = 10;
        Course tempCourse = appDao.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDao appDao) {

        //create a course
        Course tempCourse = new Course("Pacman - How to Score One Million Points");
        //create the students
        Student tempStudent1 = new Student("Roushan", "Kumar", "rk@gmail.com");
        Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");

        //add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        //save the course and associated students
        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

        appDao.save(tempCourse);

        System.out.println("Done!");
    }
}
