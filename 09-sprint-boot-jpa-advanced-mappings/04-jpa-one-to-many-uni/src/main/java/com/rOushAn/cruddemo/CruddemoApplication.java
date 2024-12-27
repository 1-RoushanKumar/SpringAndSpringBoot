package com.rOushAn.cruddemo;

import com.rOushAn.cruddemo.dao.AppDao;
import com.rOushAn.cruddemo.entity.Course;
import com.rOushAn.cruddemo.entity.Instructor;
import com.rOushAn.cruddemo.entity.InstructorDetail;
import com.rOushAn.cruddemo.entity.Review;
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

//            createCourseAndReviews(appDao);

//            retrieveCourseAndReviews(appDao);

            deleteCourseAndReviews(appDao);
        };
    }

    private void deleteCourseAndReviews(AppDao appDao) {
        int theId = 10;
        System.out.println("Deleting course id: " + theId);

        appDao.deleteCourseById(theId);

        System.out.println("Done");

    }

    private void retrieveCourseAndReviews(AppDao appDao) {
        int theId = 10;
        Course tempCourse = appDao.findCourseAndReviewByCourseId(theId);

        System.out.println(tempCourse);

        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDao appDao) {
        //create a course
        Course tempCourse = new Course("Pacman - How to Score one Million Points");

        //add some reviews
        tempCourse.addReview(new Review("Great course ... loved it!"));
        tempCourse.addReview(new Review("Course was easy to follow but could have used some more examples."));
        tempCourse.addReview(new Review("I'd like to say this course is amazing, but I've had some trouble with the video."));

        //save the course ... and leverage the cascade all
        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDao.save(tempCourse);

        System.out.println("Done!!");
    }


}
