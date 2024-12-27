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

            deleteInstructor(appDao);

        };
    }

    private void deleteInstructor(AppDao appDao) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDao.deleteInstructorById(theId);

        System.out.println("Deleted instructor id: " + theId);
    }

    private void findInstructor(AppDao appDao) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {

        //create the instructor
        Instructor tempInstructor = new Instructor("Roushan", "Kumar", "rous@gmail.com");

        //create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luc 2 Code!!!");

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
