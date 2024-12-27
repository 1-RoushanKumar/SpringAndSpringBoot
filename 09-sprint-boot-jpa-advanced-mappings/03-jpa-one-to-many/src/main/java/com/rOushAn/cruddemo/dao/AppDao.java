package com.rOushAn.cruddemo.dao;

import com.rOushAn.cruddemo.entity.Course;
import com.rOushAn.cruddemo.entity.Instructor;
import com.rOushAn.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor tempInstructor);

    Course findCourseById(int theId);

    void updateCourse(Course tempCourse);

    void deleteCourseById(int theId);

}
