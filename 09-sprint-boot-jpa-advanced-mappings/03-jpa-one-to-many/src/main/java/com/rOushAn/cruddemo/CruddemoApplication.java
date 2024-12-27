package com.rOushAn.cruddemo;

import com.rOushAn.cruddemo.dao.AppDao;
import com.rOushAn.cruddemo.entity.Course;
import com.rOushAn.cruddemo.entity.Instructor;
import com.rOushAn.cruddemo.entity.InstructorDetail;
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

//            createInstructor(appDao);

//            findInstructor(appDao);

//            findInstructorDetail(appDao);

//            deleteInstructorDetail(appDao);

//            createInstructorWithCourses(appDao);

//            findInstructorWithCourses(appDao);

//            findCoursesForInstructor(appDao);

//            findInstructorWithCoursesJoinFetch(appDao);

//            updateInstructor(appDao);

//            updatingCourse(appDao);

//            deleteInstructor(appDao);

            deleteCourseById(appDao);
        };
    }

    private void deleteCourseById(AppDao appDao) {
        int theId = 10;
        System.out.println("Deleting Course id: " + theId);

        appDao.deleteCourseById(theId);

        System.out.println("Done!!");
    }

    private void deleteInstructor(AppDao appDao) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDao.deleteInstructorById(theId);

        System.out.println("Deleted instructor id: " + theId);
    }

    private void updatingCourse(AppDao appDao) {
        int theId = 10;
        System.out.println("Finding course for instructor id: " + theId);
        Course tempCourse = appDao.findCourseById(theId);

        System.out.println("tempCourse: " + tempCourse);
        tempCourse.setTitle("Java Dev Course");

        appDao.updateCourse(tempCourse);

        System.out.println("After updating : " + tempCourse);
        System.out.println("Done!");

    }

    private void updateInstructor(AppDao appDao) {
        int theId = 1;
        System.out.println("Finding course for instructor id: " + theId);
        Instructor tempInstructor = appDao.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("Singh");

        appDao.updateInstructor(tempInstructor);

        System.out.println("After updating : " + tempInstructor);
        System.out.println("Done!");

    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        int theId = 1;
        System.out.println("Finding course for instructor id: " + theId);
        Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("Finding course for instructor id: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDao appDao) {
        int theId = 1;
        //find Instructors
        System.out.println("Finding courses for instructor id: " + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        //find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDao.findCourseByInstructorId(theId);

        //associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDao appDao) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDao appDao) {
        //create the instructor
        Instructor tempInstructor = new Instructor("Susan", "Public", "susan@gmail.com");

        //create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Gaming!!!");

        //associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse = new Course("Air Guitar Course");
        Course tempCourse2 = new Course("Pinball MasterClass");

        tempInstructor.add(tempCourse);
        tempInstructor.add(tempCourse2);
        //save the instructor
        //Note: this will also save the courses because of CascadeType.Persist
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses :" + tempInstructor.getCourses());
        appDao.save(tempInstructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDao appDao) {
        int theId = 4;
        System.out.println("Deleting instructorDetail id: " + theId);

        appDao.deleteInstructorDetailById(theId);

        System.out.println("Deleted instructorDetail id: " + theId);
    }

    private void findInstructorDetail(AppDao appDao) {
        //this id must be of InstructorDetail Table.
        int theId = 2;
        System.out.println("Finding instructor detail id: " + theId);
        InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());
        System.out.println("Done");
    }


    private void findInstructor(AppDao appDao) {
        //this id must be of Instructor Table.
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {

        //create the instructor
        Instructor tempInstructor = new Instructor("Raja", "Kumar", "raja@gmail.com");

        //create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com/youtube", "Google!!!");

        //associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        //save the instructor
        //Note: this will also save the details object
        //because of CascadeType.ALL.
        System.out.println("Saving instructor: " + tempInstructor);
        appDao.save(tempInstructor);
        System.out.println("Done!");

    }

}
