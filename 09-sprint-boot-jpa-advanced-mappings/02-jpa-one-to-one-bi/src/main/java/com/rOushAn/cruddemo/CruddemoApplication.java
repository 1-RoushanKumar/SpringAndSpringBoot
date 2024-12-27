package com.rOushAn.cruddemo;

import com.rOushAn.cruddemo.dao.AppDao;
import com.rOushAn.cruddemo.entity.Instructor;
import com.rOushAn.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

//            deleteInstructor(appDao);

//            findInstructorDetail(appDao);

            deleteInstructorDetail(appDao);

        };
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

    private void deleteInstructor(AppDao appDao) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDao.deleteInstructorById(theId);

        System.out.println("Deleted instructor id: " + theId);
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
